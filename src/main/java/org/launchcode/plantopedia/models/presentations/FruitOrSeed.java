package org.launchcode.plantopedia.models.presentations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FruitOrSeed {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    private Boolean conspicuous;
    private String color;
    private String shape;
    @JsonProperty("seed_persistence")
    private Boolean seedPersistence;

    public FruitOrSeed() {}

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
