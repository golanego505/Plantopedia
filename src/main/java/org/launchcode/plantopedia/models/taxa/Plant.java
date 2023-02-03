package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.launchcode.plantopedia.responses.links.PlantLinks;

import java.util.List;

@Entity
public class Plant extends TaxonWithSources {
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
    @Transient
    private PlantLinks links;
    @JsonProperty("main_species")
    @OneToOne
    private Species mainSpecies;
    @ManyToOne
    @JoinColumn(name = "genus_id")
    private Genus genus;
    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
    private List<SpeciesLight> species;
    @Transient
    private List<SpeciesLight> subspecies;
    @Transient
    private List<SpeciesLight> varieties;
    @Transient
    private List<SpeciesLight> hybrids;
    @Transient
    private List<SpeciesLight> forms;
    @Transient
    private List<SpeciesLight> subvarieties;

    public Plant() {
    }

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

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<SpeciesLight> getSpecies() {
        return species;
    }

    public void setSpecies(List<SpeciesLight> species) {
        this.species = species;
    }

    public List<SpeciesLight> getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(List<SpeciesLight> subspecies) {
        this.subspecies = subspecies;
    }

    public List<SpeciesLight> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<SpeciesLight> varieties) {
        this.varieties = varieties;
    }

    public List<SpeciesLight> getHybrids() {
        return hybrids;
    }

    public void setHybrids(List<SpeciesLight> hybrids) {
        this.hybrids = hybrids;
    }

    public List<SpeciesLight> getForms() {
        return forms;
    }

    public void setForms(List<SpeciesLight> forms) {
        this.forms = forms;
    }

    public List<SpeciesLight> getSubvarieties() {
        return subvarieties;
    }

    public void setSubvarieties(List<SpeciesLight> subvarieties) {
        this.subvarieties = subvarieties;
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
                ", sources=" + this.getSources() +
                '}';
    }
}
