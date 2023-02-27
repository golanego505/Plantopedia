package org.launchcode.plantopedia.controllers;

import org.launchcode.plantopedia.data.SpeciesLightRepository;
import org.launchcode.plantopedia.models.taxa.SpeciesLight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
public class PlantSearchController {
    static List<SpeciesLight> results = new ArrayList<>();
    static PagedListHolder<SpeciesLight> pagedResults = new PagedListHolder<>();
    static String searchTerm = "";
    static boolean showImages = true;
    static List<Integer> excludeNullChecked = new ArrayList<>();
    static Integer primaryOrderField = 2;
    static Integer resultsPerPage = 10;
    static final SpeciesLightField[] fields = SpeciesLightField.values();
    static Integer searchBy = SpeciesLightField.valueOf("COMMON_NAME").ordinal();
    static List<SpeciesLightField> unusedFields = Arrays.asList(SpeciesLightField.values());
    static MultiValueMap<Integer, String> queries = new LinkedMultiValueMap<>(8);
    //    static Map<Integer, String> queries = new HashMap<>();
    @Autowired
    private SpeciesLightRepository speciesLightRepository;

    @PostMapping(value = "/plants/search")
    public String processSearchForm(@RequestParam List<Integer> searchFieldOrdinals,
                                    @RequestParam List<String> q,
                                    @RequestParam(required = false) boolean showImages,
                                    @RequestParam int primaryOrderField,
                                    @RequestParam int pageSize,
                                    @RequestParam(required = false) List<Integer> hideNull) {

        for (Integer i : queries.keySet()) {
            queries.remove(i);
        }
        for (int i = 0; i < searchFieldOrdinals.size(); i++) {
            queries.add(searchFieldOrdinals.get(i), q.get(i));
        }

        MultiValueMap<SpeciesLightField, String> queryMap = new LinkedMultiValueMap<>();
        List<SpeciesLightField> searchFields = new ArrayList<>();
        searchFieldOrdinals.forEach(i -> searchFields.add(SpeciesLightField.values()[i]));
        for (int i = 0; i < searchFields.size(); i++) {
            queryMap.add(searchFields.get(i), q.get(i));
        }

        if (hideNull == null) {
            hideNull = new ArrayList<>();
        }
        List<SpeciesLightField> notNullFields = new ArrayList<>();
        hideNull.forEach(integer -> notNullFields.add(SpeciesLightField.values()[integer]));
        SpeciesLightField orderBy = SpeciesLightField.values()[primaryOrderField];
        PagedListHolder<SpeciesLight> hitsPage =
                getPagedSearchResults(queryMap, pageSize, orderBy, notNullFields);
        pagedResults = hitsPage;
        results = hitsPage.getSource();
        searchTerm = q.get(0);
        PlantSearchController.showImages = showImages;
        excludeNullChecked = hideNull;
        PlantSearchController.primaryOrderField = primaryOrderField;
        resultsPerPage = pageSize;
        searchBy = searchFieldOrdinals.get(0);
//        RestTemplate restTemplate = new RestTemplate();
//        String token = PlantListController.getClientToken(request.getRequestURI(), apiKey).getToken();
//        PlantListResponse response;
//        if (primaryOrderField.equals("")) {
//            response = restTemplate.getForObject(
//                    BASE_API_URI + "plants/search?q=" + q + "&page=" + page
//                            + "&token=" + token + "&" + filters,
//                    PlantListResponse.class);
//        } else {
//            response = restTemplate.getForObject(
//                    BASE_API_URI + "plants/search?q=" + q + "&page=" + page + "&order[" + primaryOrderField + "]=asc" +
//                            "&token=" + token + "&" + filters,
//                    PlantListResponse.class);
//        }
        return "redirect:/plants/search/results?page=1";
    }

    @RequestMapping(value = "/plants/search/results")
    public String displaySearchResults(Model model,
                                       @RequestParam int page) {
        model.addAttribute("hideNull", excludeNullChecked);
        model.addAttribute("q", searchTerm);
        model.addAttribute("showImages", showImages);
        model.addAttribute("primaryOrderField", primaryOrderField);
        pagedResults.setPage(page - 1);
        model.addAttribute("page", page);
        model.addAttribute("isFirstPage", pagedResults.isFirstPage());
        model.addAttribute("isLastPage", pagedResults.isLastPage());
        model.addAttribute("plants", pagedResults.getPageList());
        model.addAttribute("pageCount", pagedResults.getPageCount());
        model.addAttribute("resultCount", pagedResults.getNrOfElements());
        model.addAttribute("pageSize", resultsPerPage);
        model.addAttribute("fields", fields);
        model.addAttribute("searchBy", searchBy);
        model.addAttribute("unusedFields", unusedFields);
        model.addAttribute("queries", queries);
//        model.addAttribute("selectedFields", selectedFields);
        return "searchResults";
    }

    @PostMapping(value = "/toggle-images")
    public String toggleImages(@RequestParam int page,
                               @RequestParam boolean showImages) {
        PlantSearchController.showImages = showImages;
        return "redirect:/plants/search/results?" +
                "page=" + page;
    }

    @GetMapping(value = "/plants/search")
    public String showSearchForm(Model model) {
        model.addAttribute("showImages", true);
        model.addAttribute("hideNull", new ArrayList<>());
        model.addAttribute("q", "");
        model.addAttribute("pageSize", 10);
        model.addAttribute("primaryOrderField", SpeciesLightField
                .valueOf("COMMON_NAME").ordinal());
        model.addAttribute("fields", fields);
        model.addAttribute("searchBy", SpeciesLightField.valueOf("COMMON_NAME").ordinal());
        model.addAttribute("selectedFields", new ArrayList<Integer>());
        model.addAttribute("unusedFields", unusedFields);
        for (Integer i : queries.keySet()) {
            queries.remove(i);
        }
        queries.add(-1, "");
        model.addAttribute("queries", queries);
        return "searchForm";
    }

    @RequestMapping(value = "/filter-search-results")
    public String processFilters(@RequestParam Map<String, String> query) {
        String filtersForQuery = "";
        if (query.containsKey("hideNullCommonNames")) {
            Map<FilterPair, String> filterMap = new HashMap<>();
            filterMap.put(new FilterPair(false, "common_name"), "null");
            filtersForQuery = URLEncoder.encode(buildFilters(filterMap), StandardCharsets.UTF_8);
        }
        return "redirect:/plants/search?q=" + query.get("q")
                + "&page=" + query.get("page")
                + "&showImages=" + query.get("showImages")
                + "&primaryOrderField=" + query.getOrDefault("primaryOrderField", "")
                + "&filters=" + filtersForQuery;
    }

    public PagedListHolder<SpeciesLight> getPagedSearchResults(
            MultiValueMap<SpeciesLightField, String> queryMap, int pageSize, SpeciesLightField orderBy,
            List<SpeciesLightField> notNullFields) {
        List<SpeciesLight> hits = searchByFields(queryMap);
        removeNullValues(hits, notNullFields);
        sortByField(hits, orderBy);
        PagedListHolder<SpeciesLight> hitsPage = new PagedListHolder<>(hits);
        hitsPage.setPageSize(pageSize);
        return hitsPage;
    }

    public List<SpeciesLight> searchByFields(MultiValueMap<SpeciesLightField, String> q) {
        List<SpeciesLight> results = new ArrayList<>();
        speciesLightRepository.findAll().forEach(results::add);

        for (SpeciesLightField key : q.keySet()) {
            for (String term : q.get(key)) {
                List<SpeciesLight> nextRestriction = searchByField(term, key);
                results.removeIf(sl -> !nextRestriction.contains(sl));
            }
        }

        return results;
    }

    public List<SpeciesLight> searchByField(String q, SpeciesLightField field) {
        switch (field) {
//            case RANK -> {
//                return speciesLightRepository.findBySpeciesRankContainingIgnoreCase(q);
//            }
            case YEAR -> {
                return speciesLightRepository.findByYear(Integer.parseInt(q));
            }
            case GENUS -> {
                return speciesLightRepository.findByGenusContainingIgnoreCase(q);
            }
            case FAMILY -> {
                return speciesLightRepository.findByFamilyContainingIgnoreCase(q);
            }
            case AUTHOR -> {
                return speciesLightRepository.findByAuthorContainingIgnoreCase(q);
            }
            case SCIENTIFIC_NAME -> {
                return speciesLightRepository.findByScientificNameContainingIgnoreCase(q);
            }
            case BIBLIOGRAPHY -> {
                return speciesLightRepository.findByBibliographyContainingIgnoreCase(q);
            }
//            case STATUS -> {
//                return speciesLightRepository.findByStatusContainingIgnoreCase(q);
//            }
            case FAMILY_COMMON_NAME -> {
                return speciesLightRepository.findByFamilyCommonNameContainingIgnoreCase(q);
            }
            default -> {
                return speciesLightRepository.findByCommonNameContainingIgnoreCase(q);
            }
        }
    }

    private static void sortByField(List<SpeciesLight> aList, SpeciesLightField field) {
        Comparator<String> compareStringsNullsLast =
                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER);
        Comparator<SpeciesLight> compareCommonNames =
                Comparator.nullsLast(
                        Comparator.comparing(
                                SpeciesLight::getCommonName, compareStringsNullsLast
                        )
                );
        Comparator<SpeciesLight> compareScientificNames =
                Comparator.nullsLast(
                        Comparator.comparing(
                                SpeciesLight::getScientificName, compareStringsNullsLast
                        )
                );
        Comparator<SpeciesLight> compareYears =
                Comparator.nullsLast(
                        Comparator.comparing(
                                SpeciesLight::getYear
                        )
                );
        Comparator<SpeciesLight> compareAuthors =
                Comparator.nullsLast(
                        Comparator.comparing(
                                SpeciesLight::getAuthor, compareStringsNullsLast
                        )
                );
        Comparator<SpeciesLight> compareGenera =
                Comparator.nullsLast(
                        Comparator.comparing(
                                SpeciesLight::getGenus, compareStringsNullsLast
                        )
                );
        Comparator<SpeciesLight> compareFamilies =
                Comparator.nullsLast(
                        Comparator.comparing(
                                SpeciesLight::getFamily, compareStringsNullsLast
                        )
                );
        Comparator<SpeciesLight> compareBibliographies =
                Comparator.nullsLast(
                        Comparator.comparing(
                                SpeciesLight::getBibliography, compareStringsNullsLast
                        )
                );
        switch (field) {
            case BIBLIOGRAPHY -> {
                aList.sort(
                        compareBibliographies.thenComparing(
                                SpeciesLight::getId
                        )
                );
            }
            case FAMILY -> {
                aList.sort(
                        compareFamilies.thenComparing(
                                SpeciesLight::getId
                        )
                );
            }
            case GENUS -> {
                aList.sort(
                        compareGenera.thenComparing(
                                SpeciesLight::getId
                        )
                );
            }
            case AUTHOR -> {
                aList.sort(
                        compareAuthors.thenComparing(
                                SpeciesLight::getId
                        )
                );
            }
            case COMMON_NAME -> {
                aList.sort(
                        compareCommonNames.thenComparing(
                                SpeciesLight::getId
                        )
                );
            }
            case SCIENTIFIC_NAME -> {
                aList.sort(
                        compareScientificNames.thenComparing(
                                SpeciesLight::getId
                        )
                );
            }
            case YEAR -> {
                aList.sort(
                        compareYears.thenComparing(
                                SpeciesLight::getId
                        )
                );
            }
            default -> {
            }
        }
    }

    private static void removeNullValues(List<SpeciesLight> aList,
                                         List<SpeciesLightField> notNullFields) {
        for (SpeciesLightField field : notNullFields) {
            switch (field) {
                case COMMON_NAME -> {
                    aList.removeIf(sl -> sl.getCommonName() == null);
                }
                case SCIENTIFIC_NAME -> {
                    aList.removeIf(sl -> sl.getScientificName() == null);
                }
                case YEAR -> {
                    aList.removeIf(sl -> sl.getYear() == null);
                }
                case BIBLIOGRAPHY -> {
                    aList.removeIf(sl -> sl.getBibliography() == null);
                }
                case AUTHOR -> {
                    aList.removeIf(sl -> sl.getAuthor() == null);
                }
//                case STATUS -> {
//                    aList.removeIf(sl -> sl.getStatus() == null);
//                }
//                case RANK -> {
//                    aList.removeIf(sl -> sl.getRank() == null);
//                }
                case FAMILY_COMMON_NAME -> {
                    aList.removeIf(sl -> sl.getFamilyCommonName() == null);
                }
                case GENUS -> {
                    aList.removeIf(sl -> sl.getGenus() == null);
                }
                case FAMILY -> {
                    aList.removeIf(sl -> sl.getFamily() == null);
                }
                default -> {
                }
            }
        }
    }

    public String buildFilters(Map<FilterPair, String> filterMap) {
        ArrayList<String> filters = new ArrayList<>();
        for (FilterPair pair : filterMap.keySet()) {
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

    public enum SpeciesLightField {
        COMMON_NAME("common_name", "Common Name"),
        SCIENTIFIC_NAME("scientific_name", "Scientific Name"),
        YEAR("year", "Publication Year"),
        BIBLIOGRAPHY("bibliography", "Bibliography"),
        AUTHOR("author", "Author"),
        //        STATUS("status", "Status"),
//        RANK("rank", "Rank"),
        FAMILY_COMMON_NAME("family_common_name", "Family Common Name"),
        GENUS("genus", "Genus"),
        FAMILY("family", "Family");

        private final String jsonName;
        private final String formName;

        SpeciesLightField(String jsonName, String formName) {
            this.jsonName = jsonName;
            this.formName = formName;
        }

        public String getJsonName() {
            return this.jsonName;
        }

        public String getFormName() {
            return this.formName;
        }
    }
}

