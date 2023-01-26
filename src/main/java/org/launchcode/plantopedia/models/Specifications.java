package org.launchcode.plantopedia.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.launchcode.plantopedia.models.measurements.LinearMeasurementCm;

public class Specifications {
    @JsonProperty("ligneous_type")
    private String ligneousType;
    @JsonProperty("growth_form")
    private String growthForm;
    @JsonProperty("growth_habit")
    private String growthHabit;
    @JsonProperty("growth_rate")
    private String growthRate;
    @JsonProperty("average_height")
    private LinearMeasurementCm averageHeight;
    @JsonProperty("maximum_height")
    private LinearMeasurementCm maximumHeight;
    @JsonProperty("nitrogen_fixation")
    private String nitrogenFixation;
    @JsonProperty("shape_and_orientation")
    private String shapeAndOrientation;
    private String toxicity;

    @JsonProperty("ligneous_type")
    public String getLigneousType() {
        return ligneousType;
    }

    public void setLigneousType(String ligneousType) {
        this.ligneousType = ligneousType;
    }

    @JsonProperty("growth_form")
    public String getGrowthForm() {
        return growthForm;
    }

    public void setGrowthForm(String growthForm) {
        this.growthForm = growthForm;
    }

    @JsonProperty("growth_habit")
    public String getGrowthHabit() {
        return growthHabit;
    }

    public void setGrowthHabit(String growthHabit) {
        this.growthHabit = growthHabit;
    }

    @JsonProperty("growth_rate")
    public String getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(String growthRate) {
        this.growthRate = growthRate;
    }

    @JsonProperty("average_height")
    public LinearMeasurementCm getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(LinearMeasurementCm averageHeight) {
        this.averageHeight = averageHeight;
    }

    @JsonProperty("maximum_height")
    public LinearMeasurementCm getMaximumHeight() {
        return maximumHeight;
    }

    public void setMaximumHeight(LinearMeasurementCm maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    @JsonProperty("nitrogen_fixation")
    public String getNitrogenFixation() {
        return nitrogenFixation;
    }

    public void setNitrogenFixation(String nitrogenFixation) {
        this.nitrogenFixation = nitrogenFixation;
    }

    @JsonProperty("shape_and_orientation")
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

    @Override
    public String toString() {
        return "Specifications{" +
                "ligneousType='" + ligneousType + '\'' +
                ", growthForm='" + growthForm + '\'' +
                ", growthHabit='" + growthHabit + '\'' +
                ", growthRate='" + growthRate + '\'' +
                ", averageHeight=" + averageHeight +
                ", maximumHeight=" + maximumHeight +
                ", nitrogenFixation='" + nitrogenFixation + '\'' +
                ", shapeAndOrientation='" + shapeAndOrientation + '\'' +
                ", toxicity='" + toxicity + '\'' +
                '}';
    }
}
