package org.launchcode.plantopedia.models.links;

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
}
