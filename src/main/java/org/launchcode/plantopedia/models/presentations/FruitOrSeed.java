package org.launchcode.plantopedia.models.presentations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FruitOrSeed {
    private Boolean conspicuous;
    private String color;
    private String shape;
    @JsonProperty("seed_persistence")
    private Boolean seedPersistence;

    public Boolean getConspicuous() {
        return conspicuous;
    }

    public void setConspicuous(Boolean conspicuous) {
        this.conspicuous = conspicuous;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @JsonProperty("seed_persistence")
    public Boolean getSeedPersistence() {
        return seedPersistence;
    }

    public void setSeedPersistence(Boolean seedPersistence) {
        this.seedPersistence = seedPersistence;
    }

    @Override
    public String toString() {
        return "FruitOrSeed{" +
                "conspicuous=" + conspicuous +
                ", color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                ", seedPersistence=" + seedPersistence +
                '}';
    }
}
