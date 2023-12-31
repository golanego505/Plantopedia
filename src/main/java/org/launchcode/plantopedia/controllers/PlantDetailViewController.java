package org.launchcode.plantopedia.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.launchcode.plantopedia.models.taxa.Species;
import org.launchcode.plantopedia.responses.retrievals.SpeciesRetrievalResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;

import static org.launchcode.plantopedia.controllers.ClientTokenHandler.API_PATH;
import static org.launchcode.plantopedia.controllers.ClientTokenHandler.getClientToken;

@Controller
public class PlantDetailViewController {
    @RequestMapping(value = "/species/{speciesId}", method = RequestMethod.GET)
    public String plantDetails(@PathVariable int speciesId, HttpServletRequest request, Model model,
                               @Value("${TREFLE_API_TOKEN}") String apiKey) {
        String token = getClientToken(request.getRequestURI(), apiKey).getToken();

        String speciesDetailUri = API_PATH + "species/" + speciesId + "?token=" + token;
        RestTemplate restTemplate = new RestTemplate();
        SpeciesRetrievalResponse speciesData = restTemplate.getForObject(speciesDetailUri, SpeciesRetrievalResponse.class);

        if (speciesData != null) {
            Species species = speciesData.getData();
            model.addAttribute("species", species);
            if (species.getEdiblePart() != null) {
                if (species.getEdiblePart().size() > 0) {
                    ArrayList<String> parts = new ArrayList<>();
                    for (Species.EdiblePart part : species.getEdiblePart()) {
                        parts.add(part.getPart());
                    }
                    String partsList = StringUtils.join(parts, ", ");
                    model.addAttribute("edibleParts", partsList);
                }
            }
        }

        return "plantDetailView";
    }

}
