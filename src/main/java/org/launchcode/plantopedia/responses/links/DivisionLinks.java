package org.launchcode.plantopedia.responses.links;

public class DivisionLinks extends EntryLinks {
    private String subkingdom;

    public String getSubkingdom() {
        return subkingdom;
    }

    public void setSubkingdom(String subkingdom) {
        this.subkingdom = subkingdom;
    }

    @Override
    public String toString() {
        return "self='" + this.getSelf() + "'\n" +
                "subkingdom='" + subkingdom + "'\n";
    }
}
