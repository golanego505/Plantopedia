package org.launchcode.plantopedia.models;

import org.launchcode.plantopedia.models.measurements.LinearMeasurementCm;
import org.launchcode.plantopedia.models.measurements.LinearMeasurementMm;
import org.launchcode.plantopedia.models.measurements.Temperature;

public class Growth {
    private String description;
    private String sowing;
    private Integer daysToHarvest;
    private LinearMeasurementCm rowSpacing;
    private LinearMeasurementCm spread;
    private Float phMaximum;
    private Float phMinimum;
    private Integer light;
    private Integer atmosphericHumidity;
    private String growthMonths;
    private String bloomMonths;
    private String fruitMonths;
    private LinearMeasurementMm minimumPrecipitation;
    private LinearMeasurementMm maximumPrecipitation;
    private LinearMeasurementCm minimumRootDepth;
    private Temperature minimumTemperature;
    private Temperature maximumTemperature;
    private Integer soilNutriments;
    private Integer soilSalinity;
    private Integer soilTexture;
    private Integer soilHumidity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSowing() {
        return sowing;
    }

    public void setSowing(String sowing) {
        this.sowing = sowing;
    }

    public Integer getDaysToHarvest() {
        return daysToHarvest;
    }

    public void setDaysToHarvest(Integer daysToHarvest) {
        this.daysToHarvest = daysToHarvest;
    }

    public LinearMeasurementCm getRowSpacing() {
        return rowSpacing;
    }

    public void setRowSpacing(LinearMeasurementCm rowSpacing) {
        this.rowSpacing = rowSpacing;
    }

    public LinearMeasurementCm getSpread() {
        return spread;
    }

    public void setSpread(LinearMeasurementCm spread) {
        this.spread = spread;
    }

    public Float getPhMaximum() {
        return phMaximum;
    }

    public void setPhMaximum(Float phMaximum) {
        this.phMaximum = phMaximum;
    }

    public Float getPhMinimum() {
        return phMinimum;
    }

    public void setPhMinimum(Float phMinimum) {
        this.phMinimum = phMinimum;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getAtmosphericHumidity() {
        return atmosphericHumidity;
    }

    public void setAtmosphericHumidity(Integer atmosphericHumidity) {
        this.atmosphericHumidity = atmosphericHumidity;
    }

    public String getGrowthMonths() {
        return growthMonths;
    }

    public void setGrowthMonths(String growthMonths) {
        this.growthMonths = growthMonths;
    }

    public String getBloomMonths() {
        return bloomMonths;
    }

    public void setBloomMonths(String bloomMonths) {
        this.bloomMonths = bloomMonths;
    }

    public String getFruitMonths() {
        return fruitMonths;
    }

    public void setFruitMonths(String fruitMonths) {
        this.fruitMonths = fruitMonths;
    }

    public LinearMeasurementMm getMinimumPrecipitation() {
        return minimumPrecipitation;
    }

    public void setMinimumPrecipitation(LinearMeasurementMm minimumPrecipitation) {
        this.minimumPrecipitation = minimumPrecipitation;
    }

    public LinearMeasurementMm getMaximumPrecipitation() {
        return maximumPrecipitation;
    }

    public void setMaximumPrecipitation(LinearMeasurementMm maximumPrecipitation) {
        this.maximumPrecipitation = maximumPrecipitation;
    }

    public LinearMeasurementCm getMinimumRootDepth() {
        return minimumRootDepth;
    }

    public void setMinimumRootDepth(LinearMeasurementCm minimumRootDepth) {
        this.minimumRootDepth = minimumRootDepth;
    }

    public Temperature getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(Temperature minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public Temperature getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(Temperature maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public Integer getSoilNutriments() {
        return soilNutriments;
    }

    public void setSoilNutriments(Integer soilNutriments) {
        this.soilNutriments = soilNutriments;
    }

    public Integer getSoilSalinity() {
        return soilSalinity;
    }

    public void setSoilSalinity(Integer soilSalinity) {
        this.soilSalinity = soilSalinity;
    }

    public Integer getSoilTexture() {
        return soilTexture;
    }

    public void setSoilTexture(Integer soilTexture) {
        this.soilTexture = soilTexture;
    }

    public Integer getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(Integer soilHumidity) {
        this.soilHumidity = soilHumidity;
    }
}
