package org.launchcode.plantopedia.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.launchcode.plantopedia.responses.lists.PlantListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import static org.launchcode.plantopedia.controllers.PlantListController.BASE_API_URI;

@Controller
public class PlantSearchController {

    @RequestMapping(value = "/plants/search")
    public String searchPlants(Model model, @RequestParam String q, HttpServletRequest request,
                               @RequestParam(defaultValue = "1") String page,
                               @RequestParam(defaultValue = "1") Boolean showImages,
                               @Value("${TREFLE_API_TOKEN}") String apiKey) {

        RestTemplate restTemplate = new RestTemplate();
        String token = PlantListController.getClientToken(request.getRequestURI(), apiKey).getToken();
        PlantListResponse response = restTemplate.getForObject(
                BASE_API_URI + "plants/search?q=" + q + "&page=" + page + "&token=" + token,
                PlantListResponse.class);
        model.addAttribute("q", q);
        model.addAttribute("page", page);
        model.addAttribute("showImages", showImages);
        PlantListController.addPlantListToModel(model, response);
        return "listPlants";
    }
}

