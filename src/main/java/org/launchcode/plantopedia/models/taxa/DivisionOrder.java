package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.links.DivisionOrderLinks;
import org.launchcode.plantopedia.models.links.EntryLinks;

public class DivisionOrder extends Taxon {
    private String name;
    private DivisionOrderLinks links;
    private DivisionClass divisionClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryLinks getLinks() {
        return links;
    }

    public void setLinks(DivisionOrderLinks links) {
        this.links = links;
    }

    public DivisionClass getDivisionClass() {
        return divisionClass;
    }

    public void setDivisionClass(DivisionClass divisionClass) {
        this.divisionClass = divisionClass;
    }
}
