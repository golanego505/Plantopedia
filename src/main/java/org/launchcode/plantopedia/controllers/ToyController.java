package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.models.responses.lists.KingdomListResponse;
import org.launchcode.plantopedia.models.responses.retrievals.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ToyController {

    @SuppressWarnings("SpellCheckingInspection")
    @Value("${TREFLE_API_TOKEN}")
    private String apiKey;

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

    @RequestMapping("/distribution")
    @ResponseBody
    private String getDistributionZone() {

        String uri = "https://trefle.io/api/v1/distributions/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        DistributionZoneRetrievalResponse response = restTemplate.getForObject(uri, DistributionZoneRetrievalResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "DistributionZoneRetrievalResponse detail page";
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
}
