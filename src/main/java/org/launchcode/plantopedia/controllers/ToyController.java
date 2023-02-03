package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.data.*;
import org.launchcode.plantopedia.models.taxa.*;
import org.launchcode.plantopedia.responses.lists.*;
import org.launchcode.plantopedia.responses.retrievals.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/* As its name suggests, this controller is for playing around,
   experimenting, troubleshooting, etc. At this point it does
   nothing important in the application.
 */
@Controller
public class ToyController {
    public static final String API_PATH = "https://trefle.io/api/v1/";
    private String apiKey = "MY_FAKE_KEY";

    @Autowired
    private KingdomRepository kingdomRepository;
    @Autowired
    private SubkingdomRepository subkingdomRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private DivisionClassRepository classRepository;
    @Autowired
    private DivisionOrderRepository orderRepository;
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
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
        if (response != null) {
            System.out.println(response.getData());
        }
        return "KingdomListResponse detail page";
    }

//    @RequestMapping(value = "/get-data/families/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    private String getFamilyData(@PathVariable(required = false) int id) {
//        RestTemplate restTemplate = new RestTemplate();
//        FamilyRetrievalResponse response = restTemplate.getForObject(
//                API_PATH + "families/" + id + "?token=" + apiKey,
//                FamilyRetrievalResponse.class);
//        if (response != null) {
//            Family family = response.getData();
//            familyRepository.save(family);
//        }
//        return "getFamilyData page";
//    }

    @RequestMapping("/get-data/families")
    @ResponseBody
    private String getFamilies(@Value("${TREFLE_API_TOKEN}") String apiKey) {
        saveFamilies(apiKey);
        return "Saved ALL families";
    }

    @RequestMapping(value = "/get-data/genus/{id}", method = RequestMethod.GET)
    @ResponseBody
    private String getGenusData(@PathVariable(required = false) int id) {
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

    private void saveFamilies(String apiKey) {
        String uri = "https://trefle.io/api/v1/families?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        FamilyListResponse response = restTemplate.
                getForObject(uri, FamilyListResponse.class);
        if (response != null) {
            int pageCount = (int) Math.ceil(response.getMeta().getTotal() / 20.0);
            for (int i = 0; i < pageCount; i++) {
                List<Family> families = response.getData();
                for (Family family : families) {
                    familyRepository.save(family);
                }
                if (i < pageCount - 1) {
                    response = restTemplate.getForObject(
                            "https://trefle.io" + response.getLinks().getNext() +
                                    "&token=" + apiKey,
                            FamilyListResponse.class);
                }
            }
        }
    }

    @RequestMapping("/get-data/genera")
    @ResponseBody
    private String getAllGenera(@Value("${TREFLE_API_TOKEN}") String apiKey) {
        saveGenera(apiKey);
        return "Got ALL genera";
    }

    private void saveGenera(String apiKey) {
        String uri = "https://trefle.io/api/v1/genus?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        GenusListResponse response = restTemplate.
                getForObject(uri, GenusListResponse.class);
        if (response != null) {
            int pageCount = (int) Math.ceil(response.getMeta().getTotal() / 20.0);
            for (int i = 0; i < pageCount; i++) {
                List<Genus> genera = response.getData();
                for (Genus genus : genera) {
                    genusRepository.save(genus);
                }
                if (i < pageCount - 1) {
                    response = restTemplate.getForObject(
                            "https://trefle.io" + response.getLinks().getNext() +
                                    "&token=" + apiKey,
                            GenusListResponse.class);
                }
            }
        }
    }
}
