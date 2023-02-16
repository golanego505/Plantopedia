package org.launchcode.plantopedia.responses.links;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FamilyLinks extends EntryLinks {
    @JsonProperty("division_order")
    private String divisionOrder;
    @JsonProperty("genus")
    private String genera;

    @JsonProperty("division_order")
    public String getDivisionOrder() {
        return divisionOrder;
    }

    public void setDivisionOrder(String divisionOrder) {
        this.divisionOrder = divisionOrder;
    }

    public String getGenera() {
        return genera;
    }

    public void setGenera(String genera) {
        this.genera = genera;
    }

    @Override
    public String toString() {
        return "self='" + this.getSelf() + "'\n" +
                "division order='" + divisionOrder + "'\n" +
                "genus='" + genera + "'\n";
    }
}
