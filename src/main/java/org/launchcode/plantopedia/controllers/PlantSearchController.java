package org.launchcode.plantopedia.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.launchcode.plantopedia.data.SpeciesLightRepository;
import org.launchcode.plantopedia.models.taxa.SpeciesLight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    static Integer orderByField = 2;
    static Integer resultsPerPage = 10;
    @Autowired
    private SpeciesLightRepository speciesLightRepository;

    @PostMapping(value = "/plants/search")
    public String processSearchForm(Model model, HttpServletRequest request,
                                    @RequestParam String q,
                                    @RequestParam int page,
                                    @RequestParam(required = false) boolean showImages,
                                    @RequestParam int orderFieldOne,
                                    @RequestParam int pageSize,
                                    @RequestParam(required = false) List<Integer> hideNull,
                                    @Value("${TREFLE_API_TOKEN}") String apiKey) {
        if (hideNull == null) {
            hideNull = new ArrayList<>();
        }
        List<SpeciesLightField> notNullFields = new ArrayList<>();
        hideNull.forEach(integer -> notNullFields.add(SpeciesLightField.values()[integer]));
        SpeciesLightField orderBy = SpeciesLightField.values()[orderFieldOne];
        PagedListHolder<SpeciesLight> hitsPage =
                getPagedSearchResults(q, 0, pageSize, orderBy, notNullFields);
        pagedResults = hitsPage;
        results = hitsPage.getSource();
        searchTerm = q;
        PlantSearchController.showImages = showImages;
        excludeNullChecked = hideNull;
        orderByField = orderFieldOne;
        resultsPerPage = pageSize;
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
                + "page=" + page;
    }

    @RequestMapping(value = "/plants/search/results")
    public String displaySearchResults(Model model,
                                       @RequestParam int page) {
        model.addAttribute("hideNull", excludeNullChecked);
        model.addAttribute("q", searchTerm);
        model.addAttribute("showImages", showImages);
        model.addAttribute("orderFieldOne", orderByField);
        pagedResults.setPage(page - 1);
        model.addAttribute("page", page);
        model.addAttribute("isFirstPage", pagedResults.isFirstPage());
        model.addAttribute("isLastPage", pagedResults.isLastPage());
        model.addAttribute("plants", pagedResults.getPageList());
        model.addAttribute("pageCount", pagedResults.getPageCount());
        model.addAttribute("resultCount", pagedResults.getNrOfElements());
        model.addAttribute("pageSize", resultsPerPage);
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
        model.addAttribute("orderFieldOne", 2);
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
                + "&orderFieldOne=" + query.getOrDefault("orderFieldOne", "")
                + "&filters=" + filtersForQuery;
    }

    public PagedListHolder<SpeciesLight> getPagedSearchResults(
            String q, int page, int pageSize, SpeciesLightField orderBy,
            List<SpeciesLightField> notNullFields) {
        String pattern = '%' + q + '%';
        List<SpeciesLight> hits = speciesLightRepository.
                findByCommonNameLikeOrScientificNameLike(pattern, pattern);
        PlantSearchController.removeNullValues(hits, notNullFields);
        sortByField(hits, orderBy);
        PagedListHolder<SpeciesLight> hitsPage = new PagedListHolder<>(hits);
        hitsPage.setPage(page);
        hitsPage.setPageSize(pageSize);
        return hitsPage;
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
        Comparator<SpeciesLight> compareSlugs =
                Comparator.nullsLast(
                        Comparator.comparing(
                                SpeciesLight::getSlug, compareStringsNullsLast
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
            case ID -> {
                aList.sort(
                        Comparator.nullsLast(
                                Comparator.comparing(SpeciesLight::getId)
                        )
                );
            }
            case SLUG -> {
                aList.sort(
                        compareSlugs.thenComparing(
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
                case ID -> {
                    aList.removeIf(sl -> sl.getId() == null);
                }
                case SLUG -> {
                    aList.removeIf(sl -> sl.getSlug() == null);
                }
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
                case STATUS -> {
                    aList.removeIf(sl -> sl.getStatus() == null);
                }
                case RANK -> {
                    aList.removeIf(sl -> sl.getRank() == null);
                }
                case FAMILY_COMMON_NAME -> {
                    aList.removeIf(sl -> sl.getFamilyCommonName() == null);
                }
                case GENUS_ID -> {
                    aList.removeIf(sl -> sl.getGenusId() == null);
                }
                case IMAGE_URL -> {
                    aList.removeIf(sl -> sl.getImageUrl() == null);
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
        ID("id"), //0
        SLUG("slug"), //1
        COMMON_NAME("common_name"), //2
        SCIENTIFIC_NAME("scientific_name"), //3
        YEAR("year"), //4
        BIBLIOGRAPHY("bibliography"), //5
        AUTHOR("author"), //6
        STATUS("status"), //7
        RANK("rank"), //8
        FAMILY_COMMON_NAME("family_common_name"), //9
        GENUS_ID("genus_id"), //10
        IMAGE_URL("image_url"), //11
        GENUS("genus"), //12
        FAMILY("family"); //13

        private final String field;

        SpeciesLightField(String field) {
            this.field = field;
        }

        public String getField() {
            return this.field;
        }
    }
}

