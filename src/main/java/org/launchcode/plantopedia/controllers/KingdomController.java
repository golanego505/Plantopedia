package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.models.Kingdom;
import org.launchcode.plantopedia.models.TrefleKingdom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Controller
public class KingdomController {

    @Value("${TREFLE_API_TOKEN}")
    private String apiKey;

    @RequestMapping("/kingdom")
    @ResponseBody
    private String getKingdom() {

        String uri = "https://trefle.io/api/v1/kingdoms/1?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        TrefleKingdom trefleKingdom = restTemplate.getForObject(uri, TrefleKingdom.class);
        System.out.println("Kingdom: " + trefleKingdom.getData().getName());
        UriTemplate uriTemplate = new UriTemplate("https://trefle.io/api/v1/kingdoms/1?token={token}");
        return "Kingdom detail page";
    }
}
