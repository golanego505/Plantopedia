package org.launchcode.plantopedia.models.measurements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    @JsonProperty("deg_f")
    private Integer degF;
    @JsonProperty("deg_c")
    private Integer degC;

    @JsonProperty("deg_f")
    public Integer getDegF() {
        return degF;
    }

    public void setDegF(Integer degF) {
        this.degF = degF;
    }

    @JsonProperty("deg_c")
    public Integer getDegC() {
        return degC;
    }

    public void setDegC(Integer degC) {
        this.degC = degC;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "degF=" + degF +
                ", degC=" + degC +
                '}';
    }
}
