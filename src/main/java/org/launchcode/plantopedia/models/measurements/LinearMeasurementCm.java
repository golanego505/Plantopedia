package org.launchcode.plantopedia.models.measurements;

public class LinearMeasurementCm {
    private Integer cm;

    public Integer getCm() {
        return cm;
    }

    public void setCm(Integer cm) {
        this.cm = cm;
    }

    @Override
    public String toString() {
        return "LinearMeasurementCm{" +
                "cm=" + cm +
                '}';
    }
}
