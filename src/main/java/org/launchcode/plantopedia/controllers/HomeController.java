package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.models.responses.lists.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("")
public class HomeController {

    @SuppressWarnings("SpellCheckingInspection")
    @Value("${TREFLE_API_TOKEN}")
    private String apiKey;

    @RequestMapping("/home")
    public String index(Model model) {
        String listKingdomsUri = "https://trefle.io/api/v1/kingdoms?token=" + apiKey;
        String listSubkingdomsUri = "https://trefle.io/api/v1/subkingdoms?token=" + apiKey;
        String listDivisionsUri = "https://trefle.io/api/v1/divisions?token=" + apiKey;
        String listDivisionClassesUri = "https://trefle.io/api/v1/division_classes?token=" + apiKey;
        String listDivisionOrdersUri = "https://trefle.io/api/v1/division_orders?token=" + apiKey;
        String listFamiliesUri = "https://trefle.io/api/v1/families?token=" + apiKey;
        String listGeneraUri = "https://trefle.io/api/v1/genus?token=" + apiKey;
        String listPlantsUri = "https://trefle.io/api/v1/plants?token=" + apiKey;
        String listSpeciesUri = "https://trefle.io/api/v1/plants?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        KingdomListResponse kingdomListResponse = restTemplate.getForObject(
                listKingdomsUri, KingdomListResponse.class);
        if (kingdomListResponse != null) {
            model.addAttribute("kingdoms", kingdomListResponse.getData());
        }

        SubkingdomListResponse subkingdomListResponse = restTemplate.getForObject(
                listSubkingdomsUri, SubkingdomListResponse.class);
        if (subkingdomListResponse != null) {
            model.addAttribute("subkingdoms", subkingdomListResponse.getData());
        }

        DivisionListResponse divisionListResponse = restTemplate.getForObject(
                listDivisionsUri, DivisionListResponse.class);
        if (divisionListResponse != null) {
            model.addAttribute("divisions", divisionListResponse.getData());
        }

        DivisionClassListResponse divisionClassListResponse = restTemplate.getForObject(
                listDivisionClassesUri, DivisionClassListResponse.class);
        if (divisionClassListResponse != null) {
            model.addAttribute("divisionClasses", divisionClassListResponse.getData());
        }

        DivisionOrderListResponse divisionOrderListResponse = restTemplate.getForObject(
                listDivisionOrdersUri, DivisionOrderListResponse.class);
        if (divisionOrderListResponse != null) {
            model.addAttribute("divisionOrders", divisionOrderListResponse.getData());
        }

        FamilyListResponse familyListResponse = restTemplate.getForObject(
                listFamiliesUri, FamilyListResponse.class);
        if (familyListResponse != null) {
            model.addAttribute("families", familyListResponse.getData());
        }

        GenusListResponse genusListResponse = restTemplate.getForObject(
                listGeneraUri, GenusListResponse.class);
        if (genusListResponse != null) {
            model.addAttribute("genera", genusListResponse.getData());
        }

        PlantListResponse plantListResponse = restTemplate.getForObject(
                listPlantsUri, PlantListResponse.class);
        if (plantListResponse != null) {
            model.addAttribute("plants", plantListResponse.getData());
        }

        SpeciesListResponse speciesListResponse = restTemplate.getForObject(
                listSpeciesUri, SpeciesListResponse.class);
        if (speciesListResponse != null) {
            model.addAttribute("species", speciesListResponse.getData());
        }

        return "index";
    }
}
