package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import org.launchcode.plantopedia.models.links.DivisionLinks;

@Entity
public class Division extends Taxon {
    private String name;
    @Transient
    private DivisionLinks links;
    @ManyToOne
    private Subkingdom subkingdom;

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
