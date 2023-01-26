package org.launchcode.plantopedia.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.launchcode.plantopedia.models.links.TdwgUnitLinks;
import org.launchcode.plantopedia.models.taxa.Taxon;

public class TdwgUnit extends Taxon {
    private String name;
    @JsonProperty("tdwg_code")
    private String tdwgCode;
    @JsonProperty("tdwg_level")
    private Integer tdwgLevel;
    @JsonProperty("species_count")
    private Integer speciesCount;
    private TdwgUnitLinks links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("tdwg_code")
    public String getTdwgCode() {
        return tdwgCode;
    }

    public void setTdwgCode(String tdwgCode) {
        this.tdwgCode = tdwgCode;
    }

    @JsonProperty("tdwg_level")
    public Integer getTdwgLevel() {
        return tdwgLevel;
    }

    public void setTdwgLevel(Integer tdwgLevel) {
        this.tdwgLevel = tdwgLevel;
    }

    @JsonProperty("species_count")
    public Integer getSpeciesCount() {
        return speciesCount;
    }

    public void setSpeciesCount(Integer speciesCount) {
        this.speciesCount = speciesCount;
    }

    public TdwgUnitLinks getLinks() {
        return links;
    }

    public void setLinks(TdwgUnitLinks links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "TdwgUnit{" +
                "name='" + name + '\'' +
                ", tdwgCode='" + tdwgCode + '\'' +
                ", tdwgLevel=" + tdwgLevel +
                ", speciesCount=" + speciesCount +
                ", links=" + links +
                '}';
    }
}
