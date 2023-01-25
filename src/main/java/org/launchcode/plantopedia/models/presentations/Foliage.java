package org.launchcode.plantopedia.models.presentations;

public class Foliage {
    private String texture;
    private String color;
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

    public Boolean getLeafRetention() {
        return leafRetention;
    }

    public void setLeafRetention(Boolean leafRetention) {
        this.leafRetention = leafRetention;
    }
}
