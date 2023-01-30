package org.launchcode.plantopedia.models.presentations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Flower {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    private String color;
    private Boolean conspicuous;

    public Flower() {}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getConspicuous() {
        return conspicuous;
    }

    public void setConspicuous(Boolean conspicuous) {
        this.conspicuous = conspicuous;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "color='" + color + '\'' +
                ", conspicuous=" + conspicuous +
                '}';
    }
}
