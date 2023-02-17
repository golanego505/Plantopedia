package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.data.FamilyRepository;
import org.launchcode.plantopedia.data.GenusRepository;
import org.launchcode.plantopedia.models.taxa.Family;
import org.launchcode.plantopedia.models.taxa.Genus;
import org.launchcode.plantopedia.responses.lists.KingdomListResponse;
import org.launchcode.plantopedia.responses.retrievals.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/* As its name suggests, this controller is for playing around,
   experimenting, troubleshooting, etc. At this point it does
   nothing important in the application.
 */
@Controller
public class ToyController {
    public static final String API_PATH ="https://trefle.io/api/v1/";
    private String apiKey = "MY_FAKE_KEY";

    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private GenusRepository genusRepository;

    @RequestMapping("/kingdom")
    @ResponseBody
    private String getKingdom() {

        String uri = "https://trefle.io/api/v1/kingdoms/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        KingdomRetrievalResponse response = restTemplate.getForObject(uri, KingdomRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "KingdomRetrievalResponse detail page";
    }

    @RequestMapping("/subkingdom")
    @ResponseBody
    private String getSubkingdom() {

        String uri = "https://trefle.io/api/v1/subkingdoms/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SubkingdomRetrievalResponse response = restTemplate.getForObject(uri, SubkingdomRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "SubkingdomRetrievalResponse detail page";
    }

    @RequestMapping("/division")
    @ResponseBody
    private String getDivision() {

        String uri = "https://trefle.io/api/v1/divisions/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        DivisionRetrievalResponse response = restTemplate.getForObject(uri, DivisionRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "DivisionRetrievalResponse detail page";
    }

    @RequestMapping("/division_class")
    @ResponseBody
    private String getDivisionClass() {

        String uri = "https://trefle.io/api/v1/division_classes/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        DivisionClassRetrievalResponse response = restTemplate.getForObject(uri, DivisionClassRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "DivisionClassRetrievalResponse detail page";
    }

    @RequestMapping("/division_order")
    @ResponseBody
    private String getDivisionOrder() {

        String uri = "https://trefle.io/api/v1/division_orders/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        DivisionOrderRetrievalResponse response = restTemplate.getForObject(uri, DivisionOrderRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "DivisionOrderRetrievalResponse detail page";
    }

    @RequestMapping("/family")
    @ResponseBody
    private String getFamily() {

        String uri = "https://trefle.io/api/v1/families/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        FamilyRetrievalResponse response = restTemplate.getForObject(uri, FamilyRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "FamilyRetrievalResponse detail page";
    }

    @RequestMapping("/genus")
    @ResponseBody
    private String getGenus() {

        String uri = "https://trefle.io/api/v1/genus/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        GenusRetrievalResponse response = restTemplate.getForObject(uri, GenusRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "GenusRetrievalResponse detail page";
    }

    @RequestMapping("/plant")
    @ResponseBody
    private String getPlant() {

        String uri = "https://trefle.io/api/v1/plants/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        PlantRetrievalResponse response = restTemplate.getForObject(uri, PlantRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "PlantRetrievalResponse detail page";
    }

    @RequestMapping("/species")
    @ResponseBody
    private String getSpecies() {

        String uri = "https://trefle.io/api/v1/species/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SpeciesRetrievalResponse response = restTemplate.getForObject(uri, SpeciesRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "SpciesResponse detail page";
    }

    @RequestMapping("/zone")
    @ResponseBody
    private String getZone() {

        String uri = "https://trefle.io/api/v1/distributions/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        ZoneRetrievalResponse response = restTemplate.getForObject(uri, ZoneRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "ZoneRetrievalResponse detail page";
    }

    @RequestMapping("/kingdoms")
    @ResponseBody
    private String getAllKingdoms() {

        String uri = "https://trefle.io/api/v1/kingdoms?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        KingdomListResponse response = restTemplate.getForObject(uri, KingdomListResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "KingdomListResponse detail page";
    }

    @RequestMapping(value = "/get-data/families/{id}", method = RequestMethod.GET)
    @ResponseBody
    private String getFamilyData(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        FamilyRetrievalResponse response = restTemplate.getForObject(
                API_PATH + "families/" + id + "?token=" + apiKey,
                FamilyRetrievalResponse.class);
        if (response != null) {
            Family family = response.getData();
            familyRepository.save(family);
        }
        return "getFamilyData page";
    }

    @RequestMapping(value = "/get-data/genus/{id}", method = RequestMethod.GET)
    @ResponseBody
    private String getGenusData(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        GenusRetrievalResponse response = restTemplate.getForObject(
                API_PATH + "genus/" + id + "?token=" + apiKey,
            GenusRetrievalResponse.class);
        if (response != null) {
            Genus genus = response.getData();
            genusRepository.save(genus);
        }
        return "getGenusData page";
    }
}
