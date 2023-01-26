package org.launchcode.plantopedia.models.presentations;

public class Flower {
    private String color;
    private Boolean conspicuous;

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
