package org.launchcode.plantopedia.models.links;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DivisionOrderLinks extends EntryLinks {
    @JsonProperty("division_class")
    private String divisionClass;

    @JsonProperty("division_class")
    public String getDivisionClass() {
        return divisionClass;
    }

    public void setDivisionClass(String divisionClass) {
        this.divisionClass = divisionClass;
    }

    @Override
    public String toString() {
        return "self='" + this.getSelf() + "'\n" +
                ", division class='" + divisionClass + "'\n";
    }
}
