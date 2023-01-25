package org.launchcode.plantopedia.models.taxa;

import org.launchcode.plantopedia.models.links.EntryLinks;
import org.launchcode.plantopedia.models.links.FamilyLinks;

public class Family extends Taxon {
    private String name;
    private String commonName;
    private FamilyLinks links;
    private DivisionOrder divisionOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public EntryLinks getLinks() {
        return links;
    }

    public void setLinks(FamilyLinks links) {
        this.links = links;
    }

    public DivisionOrder getDivisionOrder() {
        return divisionOrder;
    }

    public void setDivisionOrder(DivisionOrder divisionOrder) {
        this.divisionOrder = divisionOrder;
    }
}
