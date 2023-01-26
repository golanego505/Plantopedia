package org.launchcode.plantopedia.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.launchcode.plantopedia.models.measurements.LinearMeasurementCm;
import org.launchcode.plantopedia.models.measurements.LinearMeasurementMm;
import org.launchcode.plantopedia.models.measurements.Temperature;

public class Growth {
    private String description;
    private String sowing;
    @JsonProperty("days_to_harvest")
    private Integer daysToHarvest;
    @JsonProperty("row_spacing")
    private LinearMeasurementCm rowSpacing;
    private LinearMeasurementCm spread;
    @JsonProperty("ph_maximum")
    private Float phMaximum;
    @JsonProperty("ph_minimum")
    private Float phMinimum;
    private Integer light;
    @JsonProperty("atmospheric_humidity")
    private Integer atmosphericHumidity;
    @JsonProperty("growth_months")
    private String growthMonths;
    @JsonProperty("bloom_months")
    private String bloomMonths;
    @JsonProperty("fruit_months")
    private String fruitMonths;
    @JsonProperty("minimum_precipitation")
    private LinearMeasurementMm minimumPrecipitation;
    @JsonProperty("maximum_precipitation")
    private LinearMeasurementMm maximumPrecipitation;
    @JsonProperty("minimum_root_depth")
    private LinearMeasurementCm minimumRootDepth;
    @JsonProperty("minimum_temperature")
    private Temperature minimumTemperature;
    @JsonProperty("maximum_temperature")
    private Temperature maximumTemperature;
    @JsonProperty("soil_nutriments")
    private Integer soilNutriments;
    @JsonProperty("soil_salinity")
    private Integer soilSalinity;
    @JsonProperty("soil_texture")
    private Integer soilTexture;
    @JsonProperty("soil_humidity")
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

    @JsonProperty("days_to_harvest")
    public Integer getDaysToHarvest() {
        return daysToHarvest;
    }

    public void setDaysToHarvest(Integer daysToHarvest) {
        this.daysToHarvest = daysToHarvest;
    }

    @JsonProperty("row_spacing")
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

    @JsonProperty("ph_maximum")
    public Float getPhMaximum() {
        return phMaximum;
    }

    public void setPhMaximum(Float phMaximum) {
        this.phMaximum = phMaximum;
    }

    @JsonProperty("ph_minimum")
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

    @JsonProperty("atmospheric_humidity")
    public Integer getAtmosphericHumidity() {
        return atmosphericHumidity;
    }

    public void setAtmosphericHumidity(Integer atmosphericHumidity) {
        this.atmosphericHumidity = atmosphericHumidity;
    }

    @JsonProperty("growth_months")
    public String getGrowthMonths() {
        return growthMonths;
    }

    public void setGrowthMonths(String growthMonths) {
        this.growthMonths = growthMonths;
    }

    @JsonProperty("bloom_months")
    public String getBloomMonths() {
        return bloomMonths;
    }

    public void setBloomMonths(String bloomMonths) {
        this.bloomMonths = bloomMonths;
    }

    @JsonProperty("fruit_months")
    public String getFruitMonths() {
        return fruitMonths;
    }

    public void setFruitMonths(String fruitMonths) {
        this.fruitMonths = fruitMonths;
    }

    @JsonProperty("minimum_precipitation")
    public LinearMeasurementMm getMinimumPrecipitation() {
        return minimumPrecipitation;
    }

    public void setMinimumPrecipitation(LinearMeasurementMm minimumPrecipitation) {
        this.minimumPrecipitation = minimumPrecipitation;
    }

    @JsonProperty("maximum_precipitation")
    public LinearMeasurementMm getMaximumPrecipitation() {
        return maximumPrecipitation;
    }

    public void setMaximumPrecipitation(LinearMeasurementMm maximumPrecipitation) {
        this.maximumPrecipitation = maximumPrecipitation;
    }

    @JsonProperty("minimum_root_depth")
    public LinearMeasurementCm getMinimumRootDepth() {
        return minimumRootDepth;
    }

    public void setMinimumRootDepth(LinearMeasurementCm minimumRootDepth) {
        this.minimumRootDepth = minimumRootDepth;
    }

    @JsonProperty("minimum_temperature")
    public Temperature getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(Temperature minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    @JsonProperty("maximum_temperature")
    public Temperature getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(Temperature maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    @JsonProperty("soil_nutriments")
    public Integer getSoilNutriments() {
        return soilNutriments;
    }

    public void setSoilNutriments(Integer soilNutriments) {
        this.soilNutriments = soilNutriments;
    }

    @JsonProperty("soil_salinity")
    public Integer getSoilSalinity() {
        return soilSalinity;
    }

    public void setSoilSalinity(Integer soilSalinity) {
        this.soilSalinity = soilSalinity;
    }

    @JsonProperty("soil_texture")
    public Integer getSoilTexture() {
        return soilTexture;
    }

    public void setSoilTexture(Integer soilTexture) {
        this.soilTexture = soilTexture;
    }

    @JsonProperty("soil_humidity")
    public Integer getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(Integer soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    @Override
    public String toString() {
        return "Growth{" +
                "description='" + description + '\'' +
                ", sowing='" + sowing + '\'' +
                ", daysToHarvest=" + daysToHarvest +
                ", rowSpacing=" + rowSpacing +
                ", spread=" + spread +
                ", phMaximum=" + phMaximum +
                ", phMinimum=" + phMinimum +
                ", light=" + light +
                ", atmosphericHumidity=" + atmosphericHumidity +
                ", growthMonths='" + growthMonths + '\'' +
                ", bloomMonths='" + bloomMonths + '\'' +
                ", fruitMonths='" + fruitMonths + '\'' +
                ", minimumPrecipitation=" + minimumPrecipitation +
                ", maximumPrecipitation=" + maximumPrecipitation +
                ", minimumRootDepth=" + minimumRootDepth +
                ", minimumTemperature=" + minimumTemperature +
                ", maximumTemperature=" + maximumTemperature +
                ", soilNutriments=" + soilNutriments +
                ", soilSalinity=" + soilSalinity +
                ", soilTexture=" + soilTexture +
                ", soilHumidity=" + soilHumidity +
                '}';
    }
}
