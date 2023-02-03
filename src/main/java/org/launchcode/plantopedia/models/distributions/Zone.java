package org.launchcode.plantopedia.models.distributions;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.launchcode.plantopedia.models.taxa.Taxon;
import org.launchcode.plantopedia.responses.links.TdwgUnitLinks;

import java.util.List;

@Entity
public class Zone extends Taxon {
    private String name;
    @JsonProperty("tdwg_code")
    private String tdwgCode;
    @JsonProperty("tdwg_level")
    private Integer tdwgLevel;
    @JsonProperty("species_count")
    private Integer speciesCount;
    @Transient
    private TdwgUnitLinks links;
    @ManyToOne
    private TdwgUnit parent;
    @ElementCollection(fetch = FetchType.LAZY, targetClass = TdwgUnit.class)
    private List<TdwgUnit> children;

    public Zone() {}

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

    public TdwgUnit getParent() {
        return parent;
    }

    public void setParent(TdwgUnit parent) {
        this.parent = parent;
    }

    public List<TdwgUnit> getChildren() {
        return children;
    }

    public void setChildren(List<TdwgUnit> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "name='" + name + '\'' +
                ", tdwgCode='" + tdwgCode + '\'' +
                ", tdwgLevel=" + tdwgLevel +
                ", speciesCount=" + speciesCount +
                ", links=" + links +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }
}
