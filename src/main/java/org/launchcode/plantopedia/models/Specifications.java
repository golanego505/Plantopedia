package org.launchcode.plantopedia.models;

import org.launchcode.plantopedia.models.measurements.LinearMeasurementCm;

public class Specifications {
    private String ligneousType;
    private String growthForm;
    private String growthHabit;
    private String growthRate;
    private LinearMeasurementCm averageHeight;
    private LinearMeasurementCm maximumHeight;
    private String nitrogenFixation;
    private String shapeAndOrientation;
    private String toxicity;

    public String getLigneousType() {
        return ligneousType;
    }

    public void setLigneousType(String ligneousType) {
        this.ligneousType = ligneousType;
    }

    public String getGrowthForm() {
        return growthForm;
    }

    public void setGrowthForm(String growthForm) {
        this.growthForm = growthForm;
    }

    public String getGrowthHabit() {
        return growthHabit;
    }

    public void setGrowthHabit(String growthHabit) {
        this.growthHabit = growthHabit;
    }

    public String getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(String growthRate) {
        this.growthRate = growthRate;
    }

    public LinearMeasurementCm getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(LinearMeasurementCm averageHeight) {
        this.averageHeight = averageHeight;
    }

    public LinearMeasurementCm getMaximumHeight() {
        return maximumHeight;
    }

    public void setMaximumHeight(LinearMeasurementCm maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    public String getNitrogenFixation() {
        return nitrogenFixation;
    }

    public void setNitrogenFixation(String nitrogenFixation) {
        this.nitrogenFixation = nitrogenFixation;
    }

    public String getShapeAndOrientation() {
        return shapeAndOrientation;
    }

    public void setShapeAndOrientation(String shapeAndOrientation) {
        this.shapeAndOrientation = shapeAndOrientation;
    }

    public String getToxicity() {
        return toxicity;
    }

    public void setToxicity(String toxicity) {
        this.toxicity = toxicity;
    }
}
