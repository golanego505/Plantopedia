package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.links.DivisionLinks;
import org.launchcode.plantopedia.models.links.EntryLinks;

public class Division extends Taxon {
    private String name;
    private DivisionLinks links;
    private Subkingdom subkingdom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryLinks getLinks() {
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
