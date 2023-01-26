package org.launchcode.plantopedia.models.links;

public class DivisionClassLinks extends EntryLinks {
    private String division;

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "self='" + this.getSelf() + "'\n" +
                "division='" + division + "'\n";
    }
}
