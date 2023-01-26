package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.launchcode.plantopedia.models.*;
import org.launchcode.plantopedia.models.presentations.Flower;
import org.launchcode.plantopedia.models.presentations.Foliage;
import org.launchcode.plantopedia.models.presentations.FruitOrSeed;

import java.util.List;

public class Species extends PlantSpecies {
    private String observations;
    private Boolean vegetable;
    private String duration;
    @JsonProperty("edible_part")
    private String ediblePart;
    private Boolean edible;
    private Images images;
    @JsonProperty("common_names")
    private CommonNames commonNames;
    private Distribution distribution;
    private Distributions distributions;
    private Flower flower;
    private Foliage foliage;
    @JsonProperty("fruit_or_seed")
    private FruitOrSeed fruitOrSeed;
    private Specifications specifications;
    private Growth growth;
    private List<Synonym> synonyms;
    private List<Source> sources;

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
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("edible_part")
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

    @JsonProperty("common_names")
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

    @JsonProperty("fruit_or_seed")
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

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    public List<Source> getSources() {
        return sources;
    }
    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "Species{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", commonName='" + this.getCommonName() + '\'' +
                ", scientificName='" + this.getScientificName() + '\'' +
                ", year=" + this.getYear() +
                ", bibliography='" + this.getBibliography() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", status='" + this.getStatus() + '\'' +
                ", rank='" + this.getRank() + '\'' +
                ", familyCommonName='" + this.getFamilyCommonName() + '\'' +
                ", genusId=" + this.getGenusId() +
                ", observations='" + observations + '\'' +
                ", vegetable=" + vegetable +
                ", imageUrl='" + this.getImageUrl() + '\'' +
                ", genus='" + this.getGenus() + '\'' +
                ", family='" + this.getFamily() + '\'' +
                ", duration='" + duration + '\'' +
                ", ediblePart='" + ediblePart + '\'' +
                ", edible=" + edible +
                ", images=" + images +
                ", commonNames=" + commonNames +
                ", distribution=" + distribution +
                ", distributions=" + distributions +
                ", flower=" + flower +
                ", foliage=" + foliage +
                ", fruitOrSeed=" + fruitOrSeed +
                ", specifications=" + specifications +
                ", growth=" + growth +
                ", links=" + this.getLinks() +
                ", synonyms=" + synonyms +
                ", sources=" + sources +
                '}';
    }
}
