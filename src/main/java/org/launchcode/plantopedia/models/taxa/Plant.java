package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.Source;
import org.launchcode.plantopedia.models.links.PlantLinks;

import java.util.ArrayList;

public class Plant extends Taxon {
    private String commonName;
    private String scientificName;
    private Integer mainSpeciesId;
    private String imageUrl;
    private Integer year;
    private String bibliography;
    private String author;
    private String familyCommonName;
    private Integer genusId;
    private String observations;
    private Boolean vegetable;
    private PlantLinks links;
    private Species mainSpecies;
    private ArrayList<Species> species;
    private ArrayList<Species> subspecies;
    private ArrayList<Species> varieties;
    private ArrayList<Species> hybrids;
    private ArrayList<Species> forms;
    private ArrayList<Species> subvarieties;
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

    public Integer getMainSpeciesId() {
        return mainSpeciesId;
    }

    public void setMainSpeciesId(Integer mainSpeciesId) {
        this.mainSpeciesId = mainSpeciesId;
    }

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

    public PlantLinks getLinks() {
        return links;
    }

    public void setLinks(PlantLinks links) {
        this.links = links;
    }

    public Species getMainSpecies() {
        return mainSpecies;
    }

    public void setMainSpecies(Species mainSpecies) {
        this.mainSpecies = mainSpecies;
    }

    public ArrayList<Species> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<Species> species) {
        this.species = species;
    }

    public ArrayList<Species> getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(ArrayList<Species> subspecies) {
        this.subspecies = subspecies;
    }

    public ArrayList<Species> getVarieties() {
        return varieties;
    }

    public void setVarieties(ArrayList<Species> varieties) {
        this.varieties = varieties;
    }

    public ArrayList<Species> getHybrids() {
        return hybrids;
    }

    public void setHybrids(ArrayList<Species> hybrids) {
        this.hybrids = hybrids;
    }

    public ArrayList<Species> getForms() {
        return forms;
    }

    public void setForms(ArrayList<Species> forms) {
        this.forms = forms;
    }

    public ArrayList<Species> getSubvarieties() {
        return subvarieties;
    }

    public void setSubvarieties(ArrayList<Species> subvarieties) {
        this.subvarieties = subvarieties;
    }

    public ArrayList<Source> getSources() {
        return sources;
    }

    public void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }
}
