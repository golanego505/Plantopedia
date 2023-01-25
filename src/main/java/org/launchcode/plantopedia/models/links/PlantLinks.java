package org.launchcode.plantopedia.models.links;

public class PlantLinks extends EntryLinks {
    private String species;
    private String genus;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
}
