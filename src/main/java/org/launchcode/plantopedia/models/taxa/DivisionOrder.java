package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.launchcode.plantopedia.responses.links.DivisionOrderLinks;

@Entity
public class DivisionOrder extends Taxon {
    private String name;
    @Transient
    private DivisionOrderLinks links;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonProperty("division_class")
    private DivisionClass divisionClass;

    public DivisionOrder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DivisionOrderLinks getLinks() {
        return links;
    }

    public void setLinks(DivisionOrderLinks links) {
        this.links = links;
    }

    @JsonProperty("division_class")
    public DivisionClass getDivisionClass() {
        return divisionClass;
    }

    public void setDivisionClass(DivisionClass divisionClass) {
        this.divisionClass = divisionClass;
    }

    @Override
    public String toString() {
        return "DivisionOrder{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", name='" + name + '\'' +
                ", links=" + links +
                ", divisionClass=" + divisionClass +
                '}';
    }
}
