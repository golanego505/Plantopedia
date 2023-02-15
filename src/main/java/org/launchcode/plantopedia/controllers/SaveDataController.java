package org.launchcode.plantopedia.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.launchcode.plantopedia.data.*;
import org.launchcode.plantopedia.models.distributions.TdwgUnit;
import org.launchcode.plantopedia.models.distributions.Zone;
import org.launchcode.plantopedia.models.taxa.*;
import org.launchcode.plantopedia.responses.lists.SpeciesListResponse;
import org.launchcode.plantopedia.responses.lists.ZoneListResponse;
import org.launchcode.plantopedia.responses.retrievals.GenusRetrievalResponse;
import org.launchcode.plantopedia.responses.retrievals.PlantRetrievalResponse;
import org.launchcode.plantopedia.responses.retrievals.SpeciesRetrievalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class SaveDataController {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SpeciesLightRepository speciesLightRepository;
    @Autowired
    private SpeciesRepository speciesRepository;
    @Autowired
    private SourceRepository sourceRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private GrowthRepository growthRepository;
    @Autowired
    private SpecificationsRepository specificationsRepository;
    @Autowired
    private FlowerRepository flowerRepository;
    @Autowired
    private FoliageRepository foliageRepository;
    @Autowired
    private FruitOrSeedRepository fruitOrSeedRepository;
    @Autowired
    private TdwgUnitRepository tdwgUnitRepository;
    @Autowired
    private SynonymRepository synonymRepository;
    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private PlantRepository plantRepository;
    @Autowired
    private GenusRepository genusRepository;

    @RequestMapping(value = "/get-data/genus/{id}")
    @ResponseBody
    public String getGenusById(@PathVariable int id, @Value("${TREFLE_API_TOKEN}") String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://trefle.io/api/v1/genus/" + id + "?token=" + apiKey;
        GenusRetrievalResponse response = restTemplate.getForObject(uri, GenusRetrievalResponse.class);
        if (response != null) {
            genusRepository.save(response.getData());
        }
        return "Genus with id=" + id + " saved.";
    }

    @RequestMapping(value = "/get-data/species-in-range")
    @ResponseBody
    public String getSpeciesInIdRange(@Value("${TREFLE_API_TOKEN}") String apiKey,
                                      @RequestParam int minId, @RequestParam int maxId) {
        saveSpeciesWithIdsInRange(apiKey, minId, maxId);
        return "Saved all species with id satisfying " + minId + "<=id<=" + maxId + ".";
    }

    @RequestMapping(value = "/get-data/plants-in-range")
    @ResponseBody
    public String getPlantsInIdRange(@Value("${TREFLE_API_TOKEN}") String apiKey,
                                     @RequestParam int minId, @RequestParam int maxId) {
        savePlantsWithIdsInRange(apiKey, minId, maxId);
        return "Saved all plants with id satisfying " + minId + "<=id<=" + maxId + ".";
    }

    @RequestMapping(value = "/get-data/species-light")
    @ResponseBody
    public String saveAllSpeciesLight(@Value("${TREFLE_API_TOKEN}") String apiKey) {
        saveSpeciesLight(apiKey);
        return "Got all species_light.";
    }

    @RequestMapping(value = "/get-data/species/{id}")
    @ResponseBody
    public String handleSaveSpeciesById(@PathVariable Integer id,
                                        @Value("${TREFLE_API_TOKEN}") String apiKey) {
        saveSpeciesByIdWithCascading(apiKey, id);
        return "Saved species with id=" + id;
    }

    @RequestMapping(value = "/get-data/zones")
    @ResponseBody
    public String getAllZones(@Value("${TREFLE_API_TOKEN}") String apiKey) {
        saveZones(apiKey);
        return "Saved all zones.";
    }

    @RequestMapping(value = "/get-data/species-up-to/{maxId}")
    @ResponseBody
    public String getSpeciesUpToMaxId(@Value("${TREFLE_API_TOKEN}") String apiKey,
                                      @PathVariable Integer maxId) {
        saveSpeciesUpToMaxId(apiKey, maxId);
        return "Saved all species with ids <=" + maxId;
    }

    @RequestMapping(value = "/get-data/species-with-common-names")
    @ResponseBody
    public String getSpeciesWithCommonNames(@Value("${TREFLE_API_TOKEN}") String apiKey) {
        saveSpeciesWithCommonNames(apiKey);
        return "Saved all species with common names.";
    }

    private void saveSpeciesLight(String apiKey) {

        String uri = "https://trefle.io/api/v1/species?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SpeciesListResponse response = restTemplate.
                getForObject(uri, SpeciesListResponse.class);
        if (response != null) {
            int pageCount = (int) Math.ceil(response.getMeta().getTotal() / 20.0);
            for (int i = 0; i < pageCount; i++) {
                assert response != null;
                List<SpeciesLight> speciesLightList = response.getData();
                for (SpeciesLight speciesLight : speciesLightList) {
                    speciesLight.setGenusForORM(em.find(Genus.class, speciesLight.getGenusId()));
                    speciesLightRepository.save(speciesLight);
                }
                if (i < pageCount - 1) {
                    response = restTemplate.getForObject(
                            "https://trefle.io" + response.getLinks().getNext() +
                                    "&token=" + apiKey,
                            SpeciesListResponse.class);
                }
            }
        }
    }

    private void saveSpeciesWithCommonNames(String apiKey) {
        String uri = "https://trefle.io/api/v1/species?filter_not[common_name]=null&token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SpeciesListResponse speciesPageResponse = restTemplate.
                getForObject(uri, SpeciesListResponse.class);
        if (speciesPageResponse != null) {
            int pageCount = (int) Math.ceil(speciesPageResponse.getMeta().getTotal() / 20.0);
            int currentSpeciesId;
            for (int i = 30; i <= pageCount; i++) {
                uri = "https://trefle.io/api/v1/species?filter_not[common_name]=null" +
                        "&page=" + i +
                        "&token=" + apiKey;
                speciesPageResponse = restTemplate.getForObject(uri, SpeciesListResponse.class);
                assert speciesPageResponse != null;
                List<SpeciesLight> speciesOnCurrentPage = speciesPageResponse.getData();
                for (SpeciesLight sl : speciesOnCurrentPage) {
                    currentSpeciesId = sl.getId();
                    saveSpeciesById(apiKey, currentSpeciesId, restTemplate);
                }
            }
        }
    }

    private void saveSpeciesById(String apiKey, Integer id) {
        String uri = "https://trefle.io/api/v1/species/" + id + "?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SpeciesRetrievalResponse response = restTemplate.getForObject(
                uri, SpeciesRetrievalResponse.class);
        if (response != null) {
            Species species = response.getData();
            List<TaxonWithSources.Source> sources = species.getSources();
            for (TaxonWithSources.Source source : sources) {
                sourceRepository.save(source);
            }
            Species.Images images = species.getImages();
            if (images.getBark() != null) {
                for (Species.Images.Image image : images.getBark()) {
                    imageRepository.save(image);
                }
            }
            if (images.getFruit() != null) {
                for (Species.Images.Image image : images.getFruit()) {
                    imageRepository.save(image);
                }
            }
            if (images.getFlower() != null) {
                for (Species.Images.Image image : images.getFlower()) {
                    imageRepository.save(image);
                }
            }
            if (images.getLeaf() != null) {
                for (Species.Images.Image image : images.getLeaf()) {
                    imageRepository.save(image);
                }
            }
            if (images.getHabit() != null) {
                for (Species.Images.Image image : images.getHabit()) {
                    imageRepository.save(image);
                }
            }
            if (images.getOther() != null) {
                for (Species.Images.Image image : images.getOther()) {
                    imageRepository.save(image);
                }
            }
            if (images.getUnspecified() != null) {
                for (Species.Images.Image image : images.getUnspecified()) {
                    imageRepository.save(image);
                }
            }
            growthRepository.save(species.getGrowth());
            specificationsRepository.save(species.getSpecifications());
            flowerRepository.save(species.getFlower());
            foliageRepository.save(species.getFoliage());
            fruitOrSeedRepository.save(species.getFruitOrSeed());
            for (Species.Synonym synonym : species.getSynonyms()) {
                synonymRepository.save(synonym);
            }
            speciesRepository.save(species);
        }
    }

    private void saveSpeciesByIdWithCascading(String apiKey, Integer id) {
        String uri = "https://trefle.io/api/v1/species/" + id + "?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        SpeciesRetrievalResponse response = restTemplate.getForObject(
                uri, SpeciesRetrievalResponse.class);
        if (response != null) {
            speciesRepository.save(response.getData());
        }
    }

    private void saveSpeciesById(String apiKey, Integer id, RestTemplate rt) {
        String uri = "https://trefle.io/api/v1/species/" + id + "?token=" + apiKey;
        SpeciesRetrievalResponse response = rt.getForObject(
                uri, SpeciesRetrievalResponse.class);
        if (response != null) {
            Species species = response.getData();
            List<TaxonWithSources.Source> sources = species.getSources();
            for (TaxonWithSources.Source source : sources) {
                sourceRepository.save(source);
            }
            Species.Images images = species.getImages();
            if (images.getBark() != null) {
                for (Species.Images.Image image : images.getBark()) {
                    imageRepository.save(image);
                }
            }
            if (images.getFruit() != null) {
                for (Species.Images.Image image : images.getFruit()) {
                    imageRepository.save(image);
                }
            }
            if (images.getFlower() != null) {
                for (Species.Images.Image image : images.getFlower()) {
                    imageRepository.save(image);
                }
            }
            if (images.getLeaf() != null) {
                for (Species.Images.Image image : images.getLeaf()) {
                    imageRepository.save(image);
                }
            }
            if (images.getHabit() != null) {
                for (Species.Images.Image image : images.getHabit()) {
                    imageRepository.save(image);
                }
            }
            if (images.getOther() != null) {
                for (Species.Images.Image image : images.getOther()) {
                    imageRepository.save(image);
                }
            }
            if (images.getUnspecified() != null) {
                for (Species.Images.Image image : images.getUnspecified()) {
                    imageRepository.save(image);
                }
            }
            growthRepository.save(species.getGrowth());
            specificationsRepository.save(species.getSpecifications());
            flowerRepository.save(species.getFlower());
            foliageRepository.save(species.getFoliage());
            fruitOrSeedRepository.save(species.getFruitOrSeed());
            for (Species.Synonym synonym : species.getSynonyms()) {
                synonymRepository.save(synonym);
            }
            speciesRepository.save(species);
        }
    }

    private void saveSpeciesUpToMaxId(String apiKey, Integer maxId) {
        RestTemplate restTemplate = new RestTemplate();
        for (int id = 1; id <= maxId; id++) {
            String uri = "https://trefle.io/api/v1/species/" + id + "?token=" + apiKey;
            try {
                SpeciesRetrievalResponse response = restTemplate.getForObject(
                        uri, SpeciesRetrievalResponse.class);
                if (response != null) {
                    Species species = response.getData();
                    List<TaxonWithSources.Source> sources = species.getSources();
                    for (TaxonWithSources.Source source : sources) {
                        sourceRepository.save(source);
                    }
                    Species.Images images = species.getImages();
                    if (images.getBark() != null) {
                        for (Species.Images.Image image : images.getBark()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getFruit() != null) {
                        for (Species.Images.Image image : images.getFruit()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getFlower() != null) {
                        for (Species.Images.Image image : images.getFlower()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getLeaf() != null) {
                        for (Species.Images.Image image : images.getLeaf()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getHabit() != null) {
                        for (Species.Images.Image image : images.getHabit()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getOther() != null) {
                        for (Species.Images.Image image : images.getOther()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getUnspecified() != null) {
                        for (Species.Images.Image image : images.getUnspecified()) {
                            imageRepository.save(image);
                        }
                    }
                    growthRepository.save(species.getGrowth());
                    specificationsRepository.save(species.getSpecifications());
                    flowerRepository.save(species.getFlower());
                    foliageRepository.save(species.getFoliage());
                    fruitOrSeedRepository.save(species.getFruitOrSeed());
                    for (Species.Synonym synonym : species.getSynonyms()) {
                        synonymRepository.save(synonym);
                    }
                    speciesRepository.save(species);
                }
            } catch (RestClientException rce) {
                System.out.println("No species with id=" + id + " found.");
            }
        }
    }

    private void saveSpeciesWithIdsInRange(String apiKey, int minId, int maxId) {
        RestTemplate restTemplate = new RestTemplate();
        for (int id = minId; id <= maxId; id++) {
            String uri = "https://trefle.io/api/v1/species/" + id + "?token=" + apiKey;
            try {
                SpeciesRetrievalResponse response = restTemplate.getForObject(
                        uri, SpeciesRetrievalResponse.class);
                if (response != null) {
                    Species species = response.getData();
                    List<TaxonWithSources.Source> sources = species.getSources();
                    for (TaxonWithSources.Source source : sources) {
                        sourceRepository.save(source);
                    }
                    Species.Images images = species.getImages();
                    if (images.getBark() != null) {
                        for (Species.Images.Image image : images.getBark()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getFruit() != null) {
                        for (Species.Images.Image image : images.getFruit()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getFlower() != null) {
                        for (Species.Images.Image image : images.getFlower()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getLeaf() != null) {
                        for (Species.Images.Image image : images.getLeaf()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getHabit() != null) {
                        for (Species.Images.Image image : images.getHabit()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getOther() != null) {
                        for (Species.Images.Image image : images.getOther()) {
                            imageRepository.save(image);
                        }
                    }
                    if (images.getUnspecified() != null) {
                        for (Species.Images.Image image : images.getUnspecified()) {
                            imageRepository.save(image);
                        }
                    }
                    growthRepository.save(species.getGrowth());
                    specificationsRepository.save(species.getSpecifications());
                    flowerRepository.save(species.getFlower());
                    foliageRepository.save(species.getFoliage());
                    fruitOrSeedRepository.save(species.getFruitOrSeed());
                    for (Species.Synonym synonym : species.getSynonyms()) {
                        synonymRepository.save(synonym);
                    }
                    speciesRepository.save(species);
                }
            } catch (RestClientException rce) {
                System.out.println("No species with id=" + id + " found.");
            }
        }
    }

    private void savePlantsWithIdsInRange(String apiKey, int minId, int maxId) {
        RestTemplate restTemplate = new RestTemplate();
        for (int id = minId; id <= maxId; id++) {
            String uri = "https://trefle.io/api/v1/plants/" + id + "?token=" + apiKey;
            try {
                PlantRetrievalResponse response = restTemplate.getForObject(
                        uri, PlantRetrievalResponse.class);
                if (response != null) {
                    Plant plant = response.getData();
                    for (TaxonWithSources.Source source : plant.getSources()) {
                        sourceRepository.save(source);
                    }
                    plantRepository.save(plant);
                }
            } catch (RestClientException rce) {
                System.out.println("No plant with id=" + id + " found.");
            }
        }
    }


    private void saveZones(String apiKey) {

        String uri = "https://trefle.io/api/v1/distributions?token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        ZoneListResponse response = restTemplate.
                getForObject(uri, ZoneListResponse.class);
        if (response != null) {
            int pageCount = (int) Math.ceil(response.getMeta().getTotal() / 20.0);
            for (int i = 0; i < pageCount; i++) {
                assert response != null;
                List<Zone> zones = response.getData();
                for (Zone zone : zones) {
                    if (zone.getParent() != null) {
                        tdwgUnitRepository.save(zone.getParent());
                    }
                    if (zone.getChildren() != null) {
                        for (TdwgUnit unit : zone.getChildren()) {
                            if (unit != null) {
                                tdwgUnitRepository.save(unit);
                            }
                        }
                    }
                    zoneRepository.save(zone);
                }
                if (i < pageCount - 1) {
                    response = restTemplate.getForObject(
                            "https://trefle.io" + response.getLinks().getNext() +
                                    "&token=" + apiKey,
                            ZoneListResponse.class);
                }
            }
        }
    }
}
