package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import org.launchcode.plantopedia.models.links.SubkingdomLinks;

@Entity
public class Subkingdom extends Taxon {
    private String name;
    @Transient
    private SubkingdomLinks links;
    @ManyToOne
    private Kingdom kingdom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubkingdomLinks getLinks() {
        return links;
    }

    public void setLinks(SubkingdomLinks links) {
        this.links = links;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    @Override
    public String toString() {
        return "Subkingdom{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", name='" + name + '\'' +
                ", links=" + links +
                ", kingdom=" + kingdom +
                '}';
    }
}
