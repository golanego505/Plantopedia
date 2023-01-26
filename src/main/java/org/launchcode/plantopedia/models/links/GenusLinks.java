package org.launchcode.plantopedia.models.links;

public class GenusLinks extends EntryLinks {
    private String plants;
    private String species;
    private String family;

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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "self='" + this.getSelf() + "'\n" +
                "plants='" + plants + "'\n" +
                "species='" + species + "'\n" +
                "family='" + family + "'\n";
    }
}
