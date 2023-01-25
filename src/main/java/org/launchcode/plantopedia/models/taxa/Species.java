package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.*;
import org.launchcode.plantopedia.models.links.EntryLinks;
import org.launchcode.plantopedia.models.links.SpeciesLinks;
import org.launchcode.plantopedia.models.presentations.Flower;
import org.launchcode.plantopedia.models.presentations.Foliage;
import org.launchcode.plantopedia.models.presentations.FruitOrSeed;

import java.util.ArrayList;

public class Species extends Taxon {
    private String commonName;
    private String scientificName;
    private Integer year;
    private String bibliography;
    private String author;
    private String status;
    private String rank;
    private String familyCommonName;
    private Integer genusId;
    private String observations;
    private Boolean vegetable;
    private String imageUrl;
    private String genus;
    private String family;
    private String duration;
    private String ediblePart;
    private Boolean edible;
    private Images images;
    private CommonNames commonNames;
    private Distribution distribution;
    private Distributions distributions;
    private Flower flower;
    private Foliage foliage;
    private FruitOrSeed fruitOrSeed;
    private Specifications specifications;
    private Growth growth;
    private SpeciesLinks links;
    private ArrayList<String> synonyms;
    private ArrayList<Source> sources;

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBibliography() {
        return bibliography;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getFamilyCommonName() {
        return familyCommonName;
    }

    public void setFamilyCommonName(String familyCommonName) {
        this.familyCommonName = familyCommonName;
    }

    public Integer getGenusId() {
        return genusId;
    }

    public void setGenusId(Integer genusId) {
        this.genusId = genusId;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Boolean getVegetable() {
        return vegetable;
    }

    public void setVegetable(Boolean vegetable) {
        this.vegetable = vegetable;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEdiblePart() {
        return ediblePart;
    }

    public void setEdiblePart(String ediblePart) {
        this.ediblePart = ediblePart;
    }

    public Boolean getEdible() {
        return edible;
    }

    public void setEdible(Boolean edible) {
        this.edible = edible;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public CommonNames getCommonNames() {
        return commonNames;
    }

    public void setCommonNames(CommonNames commonNames) {
        this.commonNames = commonNames;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public Distributions getDistributions() {
        return distributions;
    }

    public void setDistributions(Distributions distributions) {
        this.distributions = distributions;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Foliage getFoliage() {
        return foliage;
    }

    public void setFoliage(Foliage foliage) {
        this.foliage = foliage;
    }

    public FruitOrSeed getFruitOrSeed() {
        return fruitOrSeed;
    }

    public void setFruitOrSeed(FruitOrSeed fruitOrSeed) {
        this.fruitOrSeed = fruitOrSeed;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public Growth getGrowth() {
        return growth;
    }

    public void setGrowth(Growth growth) {
        this.growth = growth;
    }

    public EntryLinks getLinks() {
        return links;
    }

    public void setLinks(SpeciesLinks links) {
        this.links = links;
    }

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(ArrayList<String> synonyms) {
        this.synonyms = synonyms;
    }

    public ArrayList<Source> getSources() {
        return sources;
    }
    public void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }
}
