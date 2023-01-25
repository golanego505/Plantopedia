package org.launchcode.plantopedia.models.links;

public class FamilyLinks extends EntryLinks {
    private String divisionOrder;
    private String genus;

    public String getDivisionOrder() {
        return divisionOrder;
    }

    public void setDivisionOrder(String divisionOrder) {
        this.divisionOrder = divisionOrder;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
}
