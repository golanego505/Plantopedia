package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.links.EntryLinks;
import org.launchcode.plantopedia.models.links.KingdomLinks;

public class Kingdom extends Taxon {
    private String name;
    private KingdomLinks links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryLinks getLinks() {
        return links;
    }

    public void setLinks(KingdomLinks links) {
        this.links = links;
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
