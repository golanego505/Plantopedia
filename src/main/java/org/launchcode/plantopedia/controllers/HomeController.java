package org.launchcode.plantopedia.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.launchcode.plantopedia.models.responses.ClientTokenResponse;
import org.launchcode.plantopedia.models.responses.lists.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {

    @SuppressWarnings("SpellCheckingInspection")
    @Value("${TREFLE_API_TOKEN}")
    private String apiKey;
    public static final String API_PATH ="https://trefle.io/api/v1/";
    public static final String CLIENT_TOKEN_REQUEST_PATH = "https://trefle.io/api/auth/claim";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        String listPlantsUri = API_PATH + "plants?token=" + apiKey;
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
    public String plantListResult(Model model, @RequestParam(value = "page", defaultValue = "0") String page) {

        if (page.equals("0")) {
            return "redirect:/";
        }

        String listPlantsUri = API_PATH + "plants?token=" + apiKey + "&page=" + page;
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

    @RequestMapping(value = "plants/{plantId}", method = RequestMethod.GET)
    public String plantDetails(@PathVariable int plantId, HttpServletRequest request) {
        String token = getClientToken(request.getRequestURI()).getToken();
        return "redirect:https://trefle.io/api/v1/plants/" + plantId + "?token=" + token;
    }

    @RequestMapping(value = "parse-pagination-link", method = RequestMethod.GET)
    public String parsePaginationLink(@RequestParam String link) {
        String page = getPage(link);
        return "redirect:/plants?page=" + page;
    }

    public ClientTokenResponse getClientToken(String origin) {
        ClientTokenRequest request = new ClientTokenRequest(origin);
        HttpEntity<ClientTokenRequest> entity = new HttpEntity<>(request);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(URI.create(CLIENT_TOKEN_REQUEST_PATH + "?token=" + apiKey),
                entity, ClientTokenResponse.class);
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

    public static class ClientTokenRequest {
        private String origin;
        private String ip;

        public ClientTokenRequest(String origin) {
            this.origin = origin;
            this.ip = null;
        }

        public ClientTokenRequest(String origin, String ip) {
            this.origin = origin;
            this.ip = ip;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }
}
