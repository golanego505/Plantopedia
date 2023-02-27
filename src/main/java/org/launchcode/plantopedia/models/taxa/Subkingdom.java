package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.*;
import org.launchcode.plantopedia.responses.links.SubkingdomLinks;

@Entity
public class Subkingdom extends Taxon {
    private String name;
    @Transient
    private SubkingdomLinks links;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Kingdom kingdom;

    public Subkingdom() {
    }

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
