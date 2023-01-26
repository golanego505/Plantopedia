package org.launchcode.plantopedia.models.presentations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Foliage {
    private String texture;
    private String color;
    @JsonProperty("leaf_retention")
    private Boolean leafRetention;

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
