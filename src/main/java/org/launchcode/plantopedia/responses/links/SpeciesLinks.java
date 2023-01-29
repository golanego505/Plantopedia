package org.launchcode.plantopedia.responses.links;

public class SpeciesLinks extends EntryLinks {
    private String plant;
    private String genus;

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
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
                "plant='" + plant + "'\n" +
                "genus='" + genus + "'\n";
    }
}
