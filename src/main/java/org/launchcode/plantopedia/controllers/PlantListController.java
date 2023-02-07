package org.launchcode.plantopedia.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.launchcode.plantopedia.responses.links.ListLinks;
import org.launchcode.plantopedia.responses.lists.PlantListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.launchcode.plantopedia.controllers.ClientToken.getClientToken;

@Controller
public class PlantListController {
    public static final String API_SCHEME = "https";
    public static final String API_HOST = "trefle.io";
    public static final String API_PATH = "/api/v1/";
    public static final String BASE_API_URI = API_SCHEME + "://" + API_HOST + API_PATH;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listAllPlants(Model model, HttpServletRequest request,
                                @Value("${TREFLE_API_TOKEN}") String apiKey) {
        return "redirect:/plants";
    }

    @RequestMapping(value = "/plants", method = RequestMethod.GET)
    public String plantListByPage(Model model, HttpServletRequest request,
                                  @RequestParam(value = "page", defaultValue = "1") String page,
                                  @Value("${TREFLE_API_TOKEN}") String apiKey) {

        model.addAttribute("page", page);
        RestTemplate restTemplate = new RestTemplate();
        URI listPlants = URI.create(BASE_API_URI + "plants?token=" + apiKey + "&page=" + page);
        PlantListResponse response = restTemplate.getForObject(
                listPlants, PlantListResponse.class);
        addPlantListToModel(model, response);
        return "listPlants";
    }

    @RequestMapping(value = "/plants/detail/{plantId}", method = RequestMethod.GET)
    public String plantDetails(@PathVariable int plantId, HttpServletRequest request,
                               @Value("${TREFLE_API_TOKEN}") String apiKey) {
        String token = getClientToken(request.getRequestURI(), apiKey).getToken();
        return "redirect:https://trefle.io/api/v1/plants/" + plantId + "?token=" + token;
    }

    @RequestMapping(value = "/parse-pagination-link", method = RequestMethod.GET)
    public String parsePaginationLink(@RequestParam Map<String, String> query) {
        String searchTerm = query.get("q");
        String page = query.get("page");
        if (searchTerm == null || searchTerm.equals("")) {
            return "redirect:/plants?page=" + page;
        }
        else {
            return "redirect:/plants/search?page=" + page + "&q=" + searchTerm;
        }
    }

//    public static ClientTokenResponse getClientToken(String origin,
//                                                     @Value("${TREFLE_API_TOKEN}") String apiKey) {
//        ClientTokenRequest request = new ClientTokenRequest(origin);
//        HttpEntity<ClientTokenRequest> entity = new HttpEntity<>(request);
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.postForObject(URI.create(CLIENT_TOKEN_REQUEST_PATH + "?token=" + apiKey),
//                entity, ClientTokenResponse.class);
//    }

    public static String getPage(String query) {
        Pattern p = Pattern.compile("page=\\d+");
        Matcher m = p.matcher(query);
        boolean b = m.find();
        if (!b) {
            return "-1";
        } else {
            return m.group().replace("page=", "");
        }
    }

    public static void addPlantListToModel(Model model, PlantListResponse response) {

        if (response != null) {
            ListLinks links = response.getLinks();
            try {
                URI trefle = new URI(API_SCHEME, API_HOST, null, null);

                URI first = trefle.resolve(links.getFirst());
                model.addAttribute("firstLinkPath", first.getPath());
                model.addAttribute("firstLinkQuery", first.getQuery());

                URI last = trefle.resolve(links.getLast());
                model.addAttribute("lastLinkPath", last.getPath());
                model.addAttribute("lastLinkQuery", last.getQuery());
                model.addAttribute("pageCount", getPage(last.getQuery()));

                if (links.getPrev() != null) {
                    URI prev = trefle.resolve(links.getPrev());
                    model.addAttribute("prevLinkPath", prev.getPath());
                    model.addAttribute("prevLinkQuery", prev.getQuery());
                }

                if (links.getNext() != null) {
                    URI next = trefle.resolve(links.getNext());
                    model.addAttribute("nextLinkPath", next.getPath());
                    model.addAttribute("nextLinkQuery", next.getQuery());
                }
            } catch (URISyntaxException e) {
                model.addAttribute("error", "Bad URI");
            }
            model.addAttribute("plants", response.getData());
            model.addAttribute("links", links);
            model.addAttribute("meta", response.getMeta());
        }
    }

//    public static class ClientTokenRequest {
//        private String origin;
//        private String ip;
//
//        public ClientTokenRequest(String origin) {
//            this.origin = origin;
//            this.ip = null;
//        }
//
//        public ClientTokenRequest(String origin, String ip) {
//            this.origin = origin;
//            this.ip = ip;
//        }
//
//        public String getOrigin() {
//            return origin;
//        }
//
//        public void setOrigin(String origin) {
//            this.origin = origin;
//        }
//
//        public String getIp() {
//            return ip;
//        }
//
//        public void setIp(String ip) {
//            this.ip = ip;
//        }
//    }
}
