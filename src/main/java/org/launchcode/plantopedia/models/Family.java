package org.launchcode.plantopedia.models;

public class Family extends Taxon {
    private String name;
    private String commonName;
    private Links links;
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

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public DivisionOrder getDivisionOrder() {
        return divisionOrder;
    }

    public void setDivisionOrder(DivisionOrder divisionOrder) {
        this.divisionOrder = divisionOrder;
    }
}
