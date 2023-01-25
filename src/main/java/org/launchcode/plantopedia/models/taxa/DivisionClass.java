package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.links.DivisionClassLinks;
import org.launchcode.plantopedia.models.links.EntryLinks;

public class DivisionClass extends Taxon {
    private String name;
    private DivisionClassLinks links;
    private Division division;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryLinks getLinks() {
        return links;
    }

    public void setLinks(DivisionClassLinks links) {
        this.links = links;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
