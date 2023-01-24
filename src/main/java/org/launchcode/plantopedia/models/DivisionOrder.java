package org.launchcode.plantopedia.models;

public class DivisionOrder extends Taxon {
    private String name;
    private Links links;
    private DivisionClass divisionClass;

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

    public DivisionClass getDivisionClass() {
        return divisionClass;
    }

    public void setDivisionClass(DivisionClass divisionClass) {
        this.divisionClass = divisionClass;
    }
}
