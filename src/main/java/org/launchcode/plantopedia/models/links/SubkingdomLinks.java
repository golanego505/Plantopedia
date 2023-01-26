package org.launchcode.plantopedia.models.links;

public class SubkingdomLinks extends EntryLinks {
    private String kingdom;

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    @Override
    public String toString() {
        return "self='" + this.getSelf() + "'\n" +
                "kingdom='" + kingdom + "'\n";
    }
}
