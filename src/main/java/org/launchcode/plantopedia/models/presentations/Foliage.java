package org.launchcode.plantopedia.models.presentations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Foliage {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    private String texture;
    private String color;
    @JsonProperty("leaf_retention")
    private Boolean leafRetention;

    public Foliage() {}

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("leaf_retention")
    public Boolean getLeafRetention() {
        return leafRetention;
    }

    public void setLeafRetention(Boolean leafRetention) {
        this.leafRetention = leafRetention;
    }

    @Override
    public String toString() {
        return "Foliage{" +
                "texture='" + texture + '\'' +
                ", color='" + color + '\'' +
                ", leafRetention=" + leafRetention +
                '}';
    }
}
