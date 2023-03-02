package org.launchcode.plantopedia.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.launchcode.plantopedia.models.taxa.Plant;
import org.launchcode.plantopedia.responses.ClientTokenResponse;
import org.launchcode.plantopedia.responses.links.ListLinks;
import org.launchcode.plantopedia.responses.lists.PlantListResponse;
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
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class PlantListController {
    public static final String API_SCHEME = "https";
    public static final String API_HOST = "trefle.io";
    public static final String API_PATH = "/api/v1/";
    public static final String BASE_API_URI = API_SCHEME + "://" + API_HOST + API_PATH;
    public static final String CLIENT_TOKEN_REQUEST_PATH = API_SCHEME + "://" + API_HOST + "/api/auth/claim";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listAllPlants(Model model, HttpServletRequest request,
                                @Value("${TREFLE_API_TOKEN}") String apiKey) {
        return "index";
    }

    public String displayGivenListOfPlants(Model model, List<Plant> plants) {
        model.addAttribute("plants", plants);
        return "listPlants";
    }

    @RequestMapping(value = "/plants", method = RequestMethod.GET)
    public String plantListByPage(Model model, @RequestParam(value = "page", defaultValue = "1") String page,
                                  @RequestParam(name = "showImages", defaultValue = "1") String showImages,
                                  @RequestParam(name = "orderFieldOne", defaultValue = "") String orderFieldOne,
                                  @RequestParam(name = "plants", required = false) List<Plant> plants,
                                  @Value("${TREFLE_API_TOKEN}") String apiKey) {

        model.addAttribute("page", page);
        model.addAttribute("showImages", !(showImages.equals("0") || showImages.equals("false")));
        model.addAttribute("orderFieldOne", orderFieldOne);
        if (plants == null) {
            RestTemplate restTemplate = new RestTemplate();
            PlantListResponse response;
            URI listPlants;
            if (orderFieldOne.equals("")) {
                listPlants = URI.create(BASE_API_URI + "plants?token=" + apiKey + "&page=" + page);
            } else {
                listPlants = URI.create(BASE_API_URI + "plants?token=" + apiKey + "&page=" + page
                        + "&order[" + orderFieldOne + "]=asc");
            }
            response = restTemplate.getForObject(
                    listPlants, PlantListResponse.class);
            addPlantListToModel(model, response);
            return "listPlants";
        }
        else return displayGivenListOfPlants(model, plants);
    }

    @RequestMapping(value = "/plants/detail/{plantId}", method = RequestMethod.GET)
    public String plantDetails(@PathVariable int plantId, HttpServletRequest request,
                               @Value("${TREFLE_API_TOKEN}") String apiKey) {
        String token = getClientToken(request.getRequestURI(), apiKey).getToken();
        return "redirect:https://trefle.io/api/v1/plants/" + plantId + "?token=" + token;
    }

    @RequestMapping(value = "/parse-pagination-link")
    public String parsePaginationLink(@RequestParam Map<String, String> query) {
        if (query.containsKey("orderFieldOne")) {
            return "redirect:/order-results?page=" + query.get("page") +
                    (query.containsKey("q") ? "&q=" + query.get("q") : "")
                    + "&showImages=" + query.get("showImages") + "&orderFieldOne=" + query.get("orderFieldOne");
        }
        String page = query.get("page");
        String showImages = query.get("showImages");
        if (!query.containsKey("q")) {
            return "redirect:/plants?page=" + page + "&showImages=" + showImages;
        } else {
            String searchTerm = query.get("q");
            return "redirect:/plants/search?page=" + page + "&q=" + searchTerm + "&showImages=" + showImages;
        }
    }

    @RequestMapping(value = "/order-results")
    public String orderResults(@RequestParam Map<String, String> query) {
        if (!query.containsKey("q")) {
            return "redirect:/plants?orderFieldOne=" + query.get("orderFieldOne")
                    + "&showImages=" + query.get("showImages") + "&page=" + query.get("page");
        } else {
          return "redirect:/plants/search?q=" + query.get("q") + "&orderFieldOne=" + query.get("orderFieldOne")
                  + "&showImages=" + query.get("showImages") + "&page=" + query.get("page");
        }
    }

    public static ClientTokenResponse getClientToken(String origin,
                                                     @Value("${TREFLE_API_TOKEN}") String apiKey) {
        ClientTokenRequest request = new ClientTokenRequest(origin);
        HttpEntity<ClientTokenRequest> entity = new HttpEntity<>(request);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(URI.create(CLIENT_TOKEN_REQUEST_PATH + "?token=" + apiKey),
                entity, ClientTokenResponse.class);
    }

    public static String getPage(String query) {
        Pattern p = Pattern.compile("(?<=^|[?&])page=\\d+");
        Matcher m = p.matcher(query);
        boolean b = m.find();
        if (!b) {
            return "-1";
        } else {
            return m.group().replace("page=", "");
        }
    }

    public static String getQ(String query) {
        Pattern p = Pattern.compile("(?<=^|[?&])q=[^$&]+");
        Matcher m = p.matcher(query);
        boolean b = m.find();
        if (!b) {
            return "";
        } else {
            return m.group().replace("q=", "");
        }
    }

    public static void addPlantListToModel(Model model, PlantListResponse response) {

        if (response != null) {
            ListLinks links = response.getLinks();
            try {
                URI trefle = new URI(API_SCHEME, API_HOST, null, null);
                URI self = trefle.resolve(links.getSelf());
                model.addAttribute("self", self);
                model.addAttribute("selfLinkQuery", self.getRawQuery());
                model.addAttribute("selfLinkPath", self.getPath());

                URI first = trefle.resolve(links.getFirst());
                model.addAttribute("firstLinkPath", first.getRawPath());
                model.addAttribute("firstLinkQuery", first.getRawQuery());

                URI last = trefle.resolve(links.getLast());
                model.addAttribute("lastLinkPath", last.getRawPath());
                model.addAttribute("lastLinkQuery", last.getRawQuery());
                model.addAttribute("pageCount", getPage(last.getQuery()));

                if (links.getPrev() != null) {
                    URI prev = trefle.resolve(links.getPrev());
                    model.addAttribute("prevLinkPath", prev.getRawPath());
                    model.addAttribute("prevLinkQuery", prev.getRawQuery());
                }

                if (links.getNext() != null) {
                    URI next = trefle.resolve(links.getNext());
                    model.addAttribute("nextLinkPath", next.getRawPath());
                    model.addAttribute("nextLinkQuery", next.getRawQuery());
                }
            } catch (URISyntaxException e) {
                model.addAttribute("error", "Bad URI");
            }
            model.addAttribute("plants", response.getData());
            model.addAttribute("links", links);
            model.addAttribute("meta", response.getMeta());
        }
    }

    public static class ClientTokenRequest {
        private String origin;
        private String ip;

        public ClientTokenRequest() {
        }

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
