package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.models.responses.ClientTokenResponse;
import org.launchcode.plantopedia.models.responses.lists.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Controller
public class HomeController {

    @SuppressWarnings("SpellCheckingInspection")
    @Value("${TREFLE_API_TOKEN}")
    private String apiKey;
    public static final String API_PATH ="https://trefle.io/api/v1/";
    public static final String CLIENT_TOKEN_REQUEST_PATH = "https://trefle.io/api/auth/claim";

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("TREFLE_API_TOKEN", apiKey);

        String listPlantsUri = API_PATH + "plants?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        PlantListResponse plantListResponse = restTemplate.getForObject(
                listPlantsUri, PlantListResponse.class);
        if (plantListResponse != null) {
            model.addAttribute("plants", plantListResponse.getData());
        }

        return "index";
    }

    @RequestMapping("get-token/{plantId}")
    public String useClientToken(@PathVariable int plantId) {
        String token = getClientToken().getToken();
        return "redirect:https://trefle.io/api/v1/plants/" + plantId + "?token=" + token;
    }

    public ClientTokenResponse getClientToken() {
        ClientTokenRequest request = new ClientTokenRequest("localhost:8080");
        HttpEntity<ClientTokenRequest> entity = new HttpEntity<>(request);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(URI.create(CLIENT_TOKEN_REQUEST_PATH + "?token=" + apiKey),
                entity, ClientTokenResponse.class);
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
