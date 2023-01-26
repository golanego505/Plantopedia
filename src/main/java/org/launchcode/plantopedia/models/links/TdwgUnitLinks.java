package org.launchcode.plantopedia.models.links;

public class TdwgUnitLinks extends EntryLinks {
    private String plants;
    private String species;

    public String getPlants() {
        return plants;
    }

    public void setPlants(String plants) {
        this.plants = plants;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "self='" + this.getSelf() + "'\n" +
                "plants='" + plants + "'\n" +
                "species='" + species + "'\n";
    }
}
