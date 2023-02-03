package org.launchcode.plantopedia.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.launchcode.plantopedia.data.SpeciesLightRepository;
import org.launchcode.plantopedia.models.taxa.Genus;
import org.launchcode.plantopedia.models.taxa.SpeciesLight;
import org.launchcode.plantopedia.responses.lists.SpeciesListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class SaveDataController {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SpeciesLightRepository speciesLightRepository;

    @RequestMapping(value = "/get-data/species-light")
    @ResponseBody
    public String saveAllSpeciesLight(@Value("${TREFLE_API_TOKEN}") String apiKey) {
        saveSpeciesLight(apiKey);
        return "Got all species_light.";
    }

    private void saveSpeciesLight(String apiKey) {

        String uri = "https://trefle.io/api/v1/species?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SpeciesListResponse response = restTemplate.
                getForObject(uri, SpeciesListResponse.class);
        if (response != null) {
            int pageCount = (int) Math.ceil(response.getMeta().getTotal() / 20.0);
            for (int i = 0; i < pageCount; i++) {
                assert response != null;
                List<SpeciesLight> speciesLightList = response.getData();
                for (SpeciesLight speciesLight : speciesLightList) {
                    speciesLight.setGenusForORM(em.find(Genus.class, speciesLight.getGenusId()));
                    speciesLightRepository.save(speciesLight);
                }
                if (i < pageCount - 1) {
                    response = restTemplate.getForObject(
                            "https://trefle.io" + response.getLinks().getNext() +
                                    "&token=" + apiKey,
                            SpeciesListResponse.class);
                }
            }
        }
    }
}
