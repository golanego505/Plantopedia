package org.launchcode.plantopedia.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.launchcode.plantopedia.data.SpeciesLightRepository;
import org.launchcode.plantopedia.data.SpeciesRepository;
import org.launchcode.plantopedia.models.taxa.SpeciesLight;
import org.launchcode.plantopedia.responses.lists.PlantListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.launchcode.plantopedia.controllers.PlantListController.BASE_API_URI;

@Controller
public class PlantSearchController {

    static List<SpeciesLight> results = new ArrayList<>();
    static PagedListHolder<SpeciesLight> pagedResults = new PagedListHolder<>();
    static String searchTerm;
    @Autowired
    private SpeciesLightRepository speciesLightRepository;

    @PostMapping(value = "/plants/search")
    public String processSearchForm(Model model, HttpServletRequest request,
                               @RequestParam String q,
                               @RequestParam int page,
                               @RequestParam(defaultValue = "1") String showImages,
                               @RequestParam(name = "orderFieldOne", defaultValue = "") String orderFieldOne,
                               @RequestParam int pageSize,
                               @RequestParam(name = "filters", defaultValue = "") String filters,
                               @Value("${TREFLE_API_TOKEN}") String apiKey) {
        PagedListHolder<SpeciesLight> hitsPage = getPagedSearchResults(q, 0, pageSize);
        pagedResults = hitsPage;
        results = hitsPage.getSource();
        searchTerm = q;
//        RestTemplate restTemplate = new RestTemplate();
//        String token = PlantListController.getClientToken(request.getRequestURI(), apiKey).getToken();
//        PlantListResponse response;
//        if (orderFieldOne.equals("")) {
//            response = restTemplate.getForObject(
//                    BASE_API_URI + "plants/search?q=" + q + "&page=" + page
//                            + "&token=" + token + "&" + filters,
//                    PlantListResponse.class);
//        } else {
//            response = restTemplate.getForObject(
//                    BASE_API_URI + "plants/search?q=" + q + "&page=" + page + "&order[" + orderFieldOne + "]=asc" +
//                            "&token=" + token + "&" + filters,
//                    PlantListResponse.class);
//        }
        return "redirect:/plants/search/results?"
                + "showImages=" + showImages
                + "&page=" + page
                + "&orderFieldOne=" + orderFieldOne;
    }

    @GetMapping(value = "/plants/search/results")
    public String displaySearchResults(Model model,
                                       @RequestParam boolean showImages,
                                       @RequestParam int page,
                                       @RequestParam String orderFieldOne) {
        model.addAttribute("q", searchTerm);
        model.addAttribute("showImages", showImages);
        model.addAttribute("orderFieldOne", orderFieldOne);
        pagedResults.setPage(page - 1);
        model.addAttribute("page", page);
        model.addAttribute("isFirstPage", pagedResults.isFirstPage());
        model.addAttribute("isLastPage", pagedResults.isLastPage());
        model.addAttribute("plants", pagedResults.getPageList());
        model.addAttribute("pageCount", pagedResults.getPageCount());
        model.addAttribute("resultCount", pagedResults.getNrOfElements());
        return "searchResults";
    }

    @GetMapping(value = "/plants/search")
    public String showSearchForm(){
        return "searchForm";
    }

    @RequestMapping(value = "/filter-search-results")
    public String processFilters(@RequestParam Map<String, String> query) {
        String filtersForQuery = "";
        if(query.containsKey("hideNullCommonNames")) {
            Map<FilterPair, String> filterMap = new HashMap<>();
            filterMap.put(new FilterPair(false, "common_name"), "null");
            filtersForQuery = URLEncoder.encode(buildFilters(filterMap), StandardCharsets.UTF_8);
        }
        return "redirect:/plants/search?q=" + query.get("q")
                + "&page=" + query.get("page")
                + "&showImages=" + query.get("showImages")
                + "&orderFieldOne=" + query.getOrDefault("orderFieldOne", "")
                + "&filters=" + filtersForQuery;
    }

    public PagedListHolder<SpeciesLight> getPagedSearchResults(String q, int page, int pageSize) {
        List<SpeciesLight> hits = speciesLightRepository.findByCommonNameContainingIgnoreCase(q);
        hits.addAll(speciesLightRepository.findByScientificNameContainingIgnoreCase(q));
        PagedListHolder<SpeciesLight> hitsPage = new PagedListHolder<>(hits);
        hitsPage.setPage(page);
        hitsPage.setPageSize(pageSize);
        return hitsPage;
    }

    public String buildFilters(Map<FilterPair, String> filterMap) {
        ArrayList<String> filters = new ArrayList<>();
        for(FilterPair pair : filterMap.keySet()) {
            filters.add(pair.httpRequestParamKey() + filterMap.get(pair));
        }
        return StringUtils.join(filters, '&');
    }



    public static class FilterPair {
        //True if the filter includes results with matching values.
        //False if the filter excludes results with matching values.
        private Boolean include;
        //The field to filter on.
        private String field;

        public FilterPair(Boolean include, String field) {
            this.include = include;
            this.field = field;
        }

        public Boolean getInclude() {
            return include;
        }

        public void setInclude(Boolean include) {
            this.include = include;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String httpRequestParamKey() {
            return "filter" + (include ? "" : "_not") + "[" + field + "]=";
        }
    }

}

