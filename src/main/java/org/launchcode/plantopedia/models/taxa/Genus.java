package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.links.EntryLinks;
import org.launchcode.plantopedia.models.links.GenusLinks;

public class Genus extends Taxon {
    private String name;
    private GenusLinks links;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryLinks getLinks() {
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
