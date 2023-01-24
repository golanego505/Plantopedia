package org.launchcode.plantopedia.models;

public class Division extends Taxon {
    private String name;
    private Links links;
    private Subkingdom subkingdom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Subkingdom getSubkingdom() {
        return subkingdom;
    }

    public void setSubkingdom(Subkingdom subkingdom) {
        this.subkingdom = subkingdom;
    }
}
