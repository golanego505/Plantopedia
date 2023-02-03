package org.launchcode.plantopedia.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.launchcode.plantopedia.responses.ClientTokenResponse;
import org.launchcode.plantopedia.responses.lists.PlantListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.launchcode.plantopedia.controllers.ClientToken.API_PATH;
import static org.launchcode.plantopedia.controllers.ClientToken.getClientToken;

@Controller
public class HomeController {



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        String listPlantsUri = API_PATH + "plants?token=" + getClientToken(request.getRequestURI()).getToken();
        RestTemplate restTemplate = new RestTemplate();

        PlantListResponse plantListResponse = restTemplate.getForObject(
                listPlantsUri, PlantListResponse.class);
        if (plantListResponse != null) {
            model.addAttribute("plants", plantListResponse.getData());
            model.addAttribute("links", plantListResponse.getLinks());
            model.addAttribute("meta", plantListResponse.getMeta());
        }

        return "index";
    }

    @RequestMapping(value = "/plants", method = RequestMethod.GET)
    public String plantListResult(Model model, @RequestParam(value = "page", defaultValue = "0") String page, HttpServletRequest request) {

        if (page.equals("0")) {
            return "redirect:/";
        }

        String listPlantsUri = API_PATH + "plants?token=" + getClientToken(request.getRequestURI()).getToken() + "&page=" + page;
        RestTemplate restTemplate = new RestTemplate();

        PlantListResponse plantListResponse = restTemplate.getForObject(
                listPlantsUri, PlantListResponse.class);
        if (plantListResponse != null) {
            model.addAttribute("plants", plantListResponse.getData());
            model.addAttribute("links", plantListResponse.getLinks());
            model.addAttribute("meta", plantListResponse.getMeta());
        }

        return "index";
    }



    @RequestMapping(value = "/parse-pagination-link", method = RequestMethod.GET)
    public String parsePaginationLink(@RequestParam String link) {
        String page = getPage(link);
        return "redirect:/plants?page=" + page;
    }



    @PostMapping(value = "/plants/search")
    public String searchPlants(Model model, @RequestParam(required = false) String searchTerm, HttpServletRequest request) {

        if (searchTerm.equals("")) {
            model.addAttribute("error", "Search term cannot be blank");
        }
        else {
            RestTemplate restTemplate = new RestTemplate();
            String token = getClientToken(request.getRequestURI()).getToken();
            PlantListResponse response = restTemplate.getForObject(
                    API_PATH + "plants/search?q=" + searchTerm + "&token=" + token,
                    PlantListResponse.class);
            if (response != null) {
                model.addAttribute("plants", response.getData());
                model.addAttribute("links", response.getLinks());
                model.addAttribute("meta", response.getMeta());
            }
        }
        return "index";
    }


    public String getPage(String uri) {
        Pattern p = Pattern.compile("page=\\d+");
        Matcher m = p.matcher(uri);
        boolean b = m.find();
        if (!b) {
            return "0";
        }
        else {
            return m.group().replace("page=", "");
        }
    }


}
