package org.launchcode.plantopedia.models;

import org.launchcode.plantopedia.models.links.TdwgUnitLinks;
import org.launchcode.plantopedia.models.taxa.Taxon;

public class TdwgUnit extends Taxon {
    private String name;
    private String tdwgCode;
    private Integer tdwgLevel;
    private Integer speciesCount;
    private TdwgUnitLinks links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTdwgCode() {
        return tdwgCode;
    }

    public void setTdwgCode(String tdwgCode) {
        this.tdwgCode = tdwgCode;
    }

    public Integer getTdwgLevel() {
        return tdwgLevel;
    }

    public void setTdwgLevel(Integer tdwgLevel) {
        this.tdwgLevel = tdwgLevel;
    }

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
}
