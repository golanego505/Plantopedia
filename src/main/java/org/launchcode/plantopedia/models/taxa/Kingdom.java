package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import org.launchcode.plantopedia.responses.links.KingdomLinks;

@Entity
public class Kingdom extends Taxon {
    private String name;
    @Transient
    private KingdomLinks links;

    public Kingdom() {
    }

    public KingdomLinks getLinks() {
        return links;
    }

    public void setLinks(KingdomLinks links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Kingdom{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", name='" + name + '\'' +
                ", links=" + links +
                '}';
    }
}
