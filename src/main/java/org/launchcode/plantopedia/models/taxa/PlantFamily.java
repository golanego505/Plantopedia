package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import org.launchcode.plantopedia.responses.links.FamilyLinks;

@MappedSuperclass
public class PlantFamily extends Taxon {
    private String name;
    @JsonProperty("common_name")
    private String commonName;
    @Transient
    private FamilyLinks links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public FamilyLinks getLinks() {
        return links;
    }

    public void setLinks(FamilyLinks links) {
        this.links = links;
    }
}
