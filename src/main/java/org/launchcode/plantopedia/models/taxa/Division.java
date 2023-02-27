package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.*;
import org.launchcode.plantopedia.responses.links.DivisionLinks;

@Entity
public class Division extends Taxon {
    private String name;
    @Transient
    private DivisionLinks links;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Subkingdom subkingdom;

    public Division() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DivisionLinks getLinks() {
        return links;
    }

    public void setLinks(DivisionLinks links) {
        this.links = links;
    }

    public Subkingdom getSubkingdom() {
        return subkingdom;
    }

    public void setSubkingdom(Subkingdom subkingdom) {
        this.subkingdom = subkingdom;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", name='" + name + '\'' +
                ", links=" + links +
                ", subkingdom=" + subkingdom +
                '}';
    }
}
