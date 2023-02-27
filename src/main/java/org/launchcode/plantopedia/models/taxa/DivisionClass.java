package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.*;
import org.launchcode.plantopedia.responses.links.DivisionClassLinks;

@Entity
public class DivisionClass extends Taxon {
    private String name;
    @Transient
    private DivisionClassLinks links;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Division division;

    public DivisionClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DivisionClassLinks getLinks() {
        return links;
    }

    public void setLinks(DivisionClassLinks links) {
        this.links = links;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "DivisionClass{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", name='" + name + '\'' +
                ", links=" + links +
                ", division=" + division +
                '}';
    }
}
