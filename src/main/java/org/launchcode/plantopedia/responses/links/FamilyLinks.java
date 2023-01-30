package org.launchcode.plantopedia.responses.links;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FamilyLinks extends EntryLinks {
    @JsonProperty("division_order")
    private String divisionOrder;
    private String genus;

    @JsonProperty("division_order")
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

    @Override
    public String toString() {
        return "self='" + this.getSelf() + "'\n" +
                "division order='" + divisionOrder + "'\n" +
                "genus='" + genus + "'\n";
    }
}
