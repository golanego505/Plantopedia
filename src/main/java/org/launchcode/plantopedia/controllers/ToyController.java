package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.models.responses.entry.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class KingdomController {

    @SuppressWarnings("SpellCheckingInspection")
    @Value("${TREFLE_API_TOKEN}")
    private String apiKey;

    @RequestMapping("/kingdom")
    @ResponseBody
    private String getKingdom() {

        String uri = "https://trefle.io/api/v1/kingdoms/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        KingdomResponse response = restTemplate.getForObject(uri, KingdomResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "KingdomResponse detail page";
    }

    @RequestMapping("/subkingdom")
    @ResponseBody
    private String getSubkingdom() {

        String uri = "https://trefle.io/api/v1/subkingdoms/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SubkingdomResponse response = restTemplate.getForObject(uri, SubkingdomResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "SubkingdomResponse detail page";
    }

    @RequestMapping("/division")
    @ResponseBody
    private String getDivision() {

        String uri = "https://trefle.io/api/v1/divisions/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        DivisionResponse response = restTemplate.getForObject(uri, DivisionResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "DivisionResponse detail page";
    }

    @RequestMapping("/division_class")
    @ResponseBody
    private String getDivisionClass() {

        String uri = "https://trefle.io/api/v1/division_classes/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        DivisionClassResponse response = restTemplate.getForObject(uri, DivisionClassResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "DivisionClassResponse detail page";
    }

    @RequestMapping("/division_order")
    @ResponseBody
    private String getDivisionOrder() {

        String uri = "https://trefle.io/api/v1/division_orders/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        DivisionOrderResponse response = restTemplate.getForObject(uri, DivisionOrderResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "DivisionOrderResponse detail page";
    }

    @RequestMapping("/family")
    @ResponseBody
    private String getFamily() {

        String uri = "https://trefle.io/api/v1/families/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        FamilyResponse response = restTemplate.getForObject(uri, FamilyResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "FamilyResponse detail page";
    }

    @RequestMapping("/genus")
    @ResponseBody
    private String getGenus() {

        String uri = "https://trefle.io/api/v1/genus/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        GenusResponse response = restTemplate.getForObject(uri, GenusResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "GenusResponse detail page";
    }

    @RequestMapping("/plant")
    @ResponseBody
    private String getPlant() {

        String uri = "https://trefle.io/api/v1/plants/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        PlantResponse response = restTemplate.getForObject(uri, PlantResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "PlantResponse detail page";
    }

    @RequestMapping("/species")
    @ResponseBody
    private String getSpecies() {

        String uri = "https://trefle.io/api/v1/species/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SpeciesResponse response = restTemplate.getForObject(uri, SpeciesResponse.class);
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
        DistributionZoneResponse response = restTemplate.getForObject(uri, DistributionZoneResponse.class);
        if (response != null){
            System.out.println(response.getData());
        }
        return "DistributionZoneResponse detail page";
    }
}
