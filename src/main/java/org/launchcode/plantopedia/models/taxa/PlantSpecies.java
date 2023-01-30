package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import org.launchcode.plantopedia.responses.links.SpeciesLinks;

@MappedSuperclass
public class PlantSpecies extends Taxon {
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("scientific_name")
    private String scientificName;
    private Integer year;
    private String bibliography;
    private String author;
    private String status;
    @Column(name = "species_rank")
    private String rank;
    @JsonProperty("family_common_name")
    private String familyCommonName;
    @JsonProperty("genus_id")
    private Integer genusId;
    @JsonProperty("image_url")
    private String imageUrl;
    private String genus;
    private String family;
    @Transient
    private SpeciesLinks links;

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

    @JsonProperty("image_url")
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

    public SpeciesLinks getLinks() {
        return links;
    }

    public void setLinks(SpeciesLinks links) {
        this.links = links;
    }
}
