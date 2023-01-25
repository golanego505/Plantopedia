package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.links.EntryLinks;
import org.launchcode.plantopedia.models.links.SubkingdomLinks;

public class Subkingdom extends Taxon {
    private String name;
    private SubkingdomLinks links;
    private Kingdom kingdom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryLinks getLinks() {
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
}
