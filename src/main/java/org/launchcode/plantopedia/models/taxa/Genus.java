package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import org.launchcode.plantopedia.models.links.GenusLinks;

@Entity
public class Genus extends Taxon {
    private String name;
    @Transient
    private GenusLinks links;
    @ManyToOne
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenusLinks getLinks() {
        return links;
    }

    public void setLinks(GenusLinks links) {
        this.links = links;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Genus{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", name='" + name + '\'' +
                ", links=" + links +
                ", family=" + family +
                '}';
    }
}
