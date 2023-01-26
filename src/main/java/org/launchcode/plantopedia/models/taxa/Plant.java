package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.launchcode.plantopedia.models.Source;
import org.launchcode.plantopedia.models.links.PlantLinks;

import java.util.List;

public class Plant extends Taxon {
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("scientific_name")
    private String scientificName;
    @JsonProperty("main_species_id")
    private Integer mainSpeciesId;
    @JsonProperty("image_url")
    private String imageUrl;
    private Integer year;
    private String bibliography;
    private String author;
    @JsonProperty("family_common_name")
    private String familyCommonName;
    @JsonProperty("genus_id")
    private Integer genusId;
    private String observations;
    private Boolean vegetable;
    private PlantLinks links;
    @JsonProperty("main_species")
    private Species mainSpecies;
    private PlantGenus genus;
    private PlantFamily family;
    private List<PlantSpecies> species;
    private List<PlantSpecies> subspecies;
    private List<PlantSpecies> varieties;
    private List<PlantSpecies> hybrids;
    private List<PlantSpecies> forms;
    private List<PlantSpecies> subvarieties;
    private List<Source> sources;

    @JsonProperty("common_name")
    public String getCommonName() {
        return commonName;
    }
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @JsonProperty("scientific_name")
    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    @JsonProperty("main_species_id")
    public Integer getMainSpeciesId() {
        return mainSpeciesId;
    }

    public void setMainSpeciesId(Integer mainSpeciesId) {
        this.mainSpeciesId = mainSpeciesId;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    @JsonProperty("family_common_name")
    public String getFamilyCommonName() {
        return familyCommonName;
    }

    public void setFamilyCommonName(String familyCommonName) {
        this.familyCommonName = familyCommonName;
    }

    @JsonProperty("genus_id")
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

    public PlantLinks getLinks() {
        return links;
    }

    public void setLinks(PlantLinks links) {
        this.links = links;
    }

    @JsonProperty("main_species")
    public Species getMainSpecies() {
        return mainSpecies;
    }

    public void setMainSpecies(Species mainSpecies) {
        this.mainSpecies = mainSpecies;
    }

    public PlantGenus getGenus() {
        return genus;
    }

    public void setGenus(PlantGenus genus) {
        this.genus = genus;
    }

    public PlantFamily getFamily() {
        return family;
    }

    public void setFamily(PlantFamily family) {
        this.family = family;
    }

    public List<PlantSpecies> getSpecies() {
        return species;
    }

    public void setSpecies(List<PlantSpecies> species) {
        this.species = species;
    }

    public List<PlantSpecies> getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(List<PlantSpecies> subspecies) {
        this.subspecies = subspecies;
    }

    public List<PlantSpecies> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<PlantSpecies> varieties) {
        this.varieties = varieties;
    }

    public List<PlantSpecies> getHybrids() {
        return hybrids;
    }

    public void setHybrids(List<PlantSpecies> hybrids) {
        this.hybrids = hybrids;
    }

    public List<PlantSpecies> getForms() {
        return forms;
    }

    public void setForms(List<PlantSpecies> forms) {
        this.forms = forms;
    }

    public List<PlantSpecies> getSubvarieties() {
        return subvarieties;
    }

    public void setSubvarieties(List<PlantSpecies> subvarieties) {
        this.subvarieties = subvarieties;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", commonName='" + commonName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", mainSpeciesId=" + mainSpeciesId +
                ", imageUrl='" + imageUrl + '\'' +
                ", year=" + year +
                ", bibliography='" + bibliography + '\'' +
                ", author='" + author + '\'' +
                ", familyCommonName='" + familyCommonName + '\'' +
                ", genusId=" + genusId +
                ", observations='" + observations + '\'' +
                ", vegetable=" + vegetable +
                ", links=" + links +
                ", mainSpecies=" + mainSpecies +
                ", species=" + species +
                ", subspecies=" + subspecies +
                ", varieties=" + varieties +
                ", hybrids=" + hybrids +
                ", forms=" + forms +
                ", subvarieties=" + subvarieties +
                ", sources=" + sources +
                '}';
    }
}
