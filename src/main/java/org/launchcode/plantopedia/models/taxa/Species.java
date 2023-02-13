package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import org.launchcode.plantopedia.models.distributions.Distributions;

import java.util.List;

@Entity
public class Species extends SpeciesCoreDataWithSources {
    private String observations;
    private Boolean vegetable;
    @ElementCollection
    @CollectionTable(name = "durations")
    @Enumerated(EnumType.STRING)
    private List<Duration> duration;
    @JsonProperty("edible_part")
    @ElementCollection
    @CollectionTable(name = "edible_parts")
    @Enumerated(EnumType.STRING)
    private List<EdiblePart> ediblePart;
    private Boolean edible;
    @Embedded
    private Images images;
    @JsonProperty("common_names")
    @Embedded
    private CommonNames commonNames;
    @Embedded
    private Distributions distributions;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Flower flower;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Foliage foliage;
    @JsonProperty("fruit_or_seed")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private FruitOrSeed fruitOrSeed;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Specifications specifications;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Growth growth;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "species_synonym", inverseJoinColumns = {
            @JoinColumn(name = "synonym_id")
    })
    private List<Synonym> synonyms;

    public Species() {}

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Boolean getVegetable() {
        return vegetable;
    }

    public void setVegetable(Boolean vegetable) {
        this.vegetable = vegetable;
    }
    public List<Duration> getDuration() {
        return duration;
    }

    public void setDuration(List<Duration> duration) {
        this.duration = duration;
    }

    @JsonProperty("edible_part")
    public List<EdiblePart> getEdiblePart() {
        return ediblePart;
    }

    public void setEdiblePart(List<EdiblePart> ediblePart) {
        this.ediblePart = ediblePart;
    }

    public Boolean getEdible() {
        return edible;
    }

    public void setEdible(Boolean edible) {
        this.edible = edible;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @JsonProperty("common_names")
    public CommonNames getCommonNames() {
        return commonNames;
    }

    public void setCommonNames(CommonNames commonNames) {
        this.commonNames = commonNames;
    }

    public Distributions getDistributions() {
        return distributions;
    }

    public void setDistributions(Distributions distributions) {
        this.distributions = distributions;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Foliage getFoliage() {
        return foliage;
    }

    public void setFoliage(Foliage foliage) {
        this.foliage = foliage;
    }

    @JsonProperty("fruit_or_seed")
    public FruitOrSeed getFruitOrSeed() {
        return fruitOrSeed;
    }

    public void setFruitOrSeed(FruitOrSeed fruitOrSeed) {
        this.fruitOrSeed = fruitOrSeed;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public Growth getGrowth() {
        return growth;
    }

    public void setGrowth(Growth growth) {
        this.growth = growth;
    }

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "Species{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", commonName='" + this.getCommonName() + '\'' +
                ", scientificName='" + this.getScientificName() + '\'' +
                ", year=" + this.getYear() +
                ", bibliography='" + this.getBibliography() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", status='" + this.getStatus() + '\'' +
                ", rank='" + this.getRank() + '\'' +
                ", familyCommonName='" + this.getFamilyCommonName() + '\'' +
                ", genusId=" + this.getGenusId() +
                ", observations='" + observations + '\'' +
                ", vegetable=" + vegetable +
                ", imageUrl='" + this.getImageUrl() + '\'' +
                ", genus='" + this.getGenus() + '\'' +
                ", family='" + this.getFamily() + '\'' +
                ", duration='" + duration + '\'' +
                ", ediblePart='" + ediblePart + '\'' +
                ", edible=" + edible +
                ", images=" + images +
                ", commonNames=" + commonNames +
                ", distributions=" + distributions +
                ", flower=" + flower +
                ", foliage=" + foliage +
                ", fruitOrSeed=" + fruitOrSeed +
                ", specifications=" + specifications +
                ", growth=" + growth +
                ", links=" + this.getLinks() +
                ", synonyms=" + synonyms +
                ", sources=" + this.getSources() +
                '}';
    }

    @Embeddable
    public static class Images {
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinTable(name = "flower_images",
                joinColumns = @JoinColumn(name = "species_id"),
                inverseJoinColumns = @JoinColumn(name = "image_id")
        )
        private List<Image> flower;
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinTable(name = "leaf_images",
                joinColumns = @JoinColumn(name = "species_id"),
                inverseJoinColumns = @JoinColumn(name = "image_id")
        )
        private List<Image> leaf;
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinTable(name = "habit_images",
                joinColumns = @JoinColumn(name = "species_id"),
                inverseJoinColumns = @JoinColumn(name = "image_id")
        )
        private List<Image> habit;
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinTable(name = "fruit_images",
                joinColumns = @JoinColumn(name = "species_id"),
                inverseJoinColumns = @JoinColumn(name = "image_id")
        )
        private List<Image> fruit;
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinTable(name = "bark_images",
                joinColumns = @JoinColumn(name = "species_id"),
                inverseJoinColumns = @JoinColumn(name = "image_id")
        )
        private List<Image> bark;
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinTable(name = "other_images",
                joinColumns = @JoinColumn(name = "species_id"),
                inverseJoinColumns = @JoinColumn(name = "image_id")
        )
        private List<Image> other;
        @JsonProperty("")
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinTable(name = "unspecified_images",
                joinColumns = @JoinColumn(name = "species_id"),
                inverseJoinColumns = @JoinColumn(name = "image_id")
        )
        private List<Image> unspecified;

        public Images() {}

        public List<Image> getFlower() {
            return flower;
        }

        public void setFlower(List<Image> flower) {
            this.flower = flower;
        }

        public List<Image> getLeaf() {
            return leaf;
        }

        public void setLeaf(List<Image> leaf) {
            this.leaf = leaf;
        }

        public List<Image> getHabit() {
            return habit;
        }

        public void setHabit(List<Image> habit) {
            this.habit = habit;
        }

        public List<Image> getFruit() {
            return fruit;
        }

        public void setFruit(List<Image> fruit) {
            this.fruit = fruit;
        }

        public List<Image> getBark() {
            return bark;
        }

        public void setBark(List<Image> bark) {
            this.bark = bark;
        }

        public List<Image> getOther() {
            return other;
        }

        public void setOther(List<Image> other) {
            this.other = other;
        }

        public List<Image> getUnspecified() {
            return unspecified;
        }

        public void setUnspecified(List<Image> unspecified) {
            this.unspecified = unspecified;
        }

        @Override
        public String toString() {
            return "Images{" +
                    "flower=" + flower +
                    ", leaf=" + leaf +
                    ", habit=" + habit +
                    ", fruit=" + fruit +
                    ", bark=" + bark +
                    ", other=" + other +
                    '}';
        }

        @Entity
        @Table(name = "image")
        public static class Image {
            @Id
            private Integer id;
            @JsonProperty("image_url")
            @Column(length = 511)
            private String imageUrl;
            private String copyright;

            public Image() {}

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            @JsonProperty("image_url")
            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            @Override
            public String toString() {
                return "Image{" +
                        "id=" + id +
                        ", imageUrl='" + imageUrl + '\'' +
                        ", copyright='" + copyright + '\'' +
                        '}';
            }
        }
    }

    @Entity
    @Table(name = "growth")
    @Access(AccessType.FIELD)
    public static class Growth {
        @Id
        @GeneratedValue
        @JsonIgnore
        private Integer id;
        private String description;
        private String sowing;
        @JsonProperty("days_to_harvest")
        private Float daysToHarvest;
        @JsonProperty("row_spacing")
        @Transient
        private LinearMeasurementCm rowSpacing;
        @Transient
        private LinearMeasurementCm spread;
        @JsonProperty("ph_maximum")
        private Float phMaximum;
        @JsonProperty("ph_minimum")
        private Float phMinimum;
        private Integer light;
        @JsonProperty("atmospheric_humidity")
        private Integer atmosphericHumidity;
        @JsonProperty("growth_months")
        @ElementCollection
        @CollectionTable(name = "growth_months",
                joinColumns = {
                @JoinColumn(name = "growth_id", referencedColumnName = "id")
                })
        @Enumerated(EnumType.STRING)
        private List<Month> growthMonths;
        @JsonProperty("bloom_months")
        @ElementCollection
        @CollectionTable(name = "bloom_months",
                joinColumns = {
                        @JoinColumn(name = "growth_id", referencedColumnName = "id")
                })
        @Enumerated(EnumType.STRING)
        private List<Month> bloomMonths;
        @JsonProperty("fruit_months")
        @ElementCollection
        @CollectionTable(name = "fruit_months",
                joinColumns = {
                        @JoinColumn(name = "growth_id", referencedColumnName = "id")
                })
        @Enumerated(EnumType.STRING)
        private List<Month> fruitMonths;
        @JsonProperty("minimum_precipitation")
        @Transient
        private LinearMeasurementMm minimumPrecipitation;
        @JsonProperty("maximum_precipitation")
        @Transient
        private LinearMeasurementMm maximumPrecipitation;
        @JsonProperty("minimum_root_depth")
        @Transient
        private LinearMeasurementCm minimumRootDepth;
        @JsonProperty("minimum_temperature")
        @Transient
        private Temperature minimumTemperature;
        @JsonProperty("maximum_temperature")
        @Transient
        private Temperature maximumTemperature;
        @JsonProperty("soil_nutriments")
        private Integer soilNutriments;
        @JsonProperty("soil_salinity")
        private Integer soilSalinity;
        @JsonProperty("soil_texture")
        private Integer soilTexture;
        @JsonProperty("soil_humidity")
        private Integer soilHumidity;
        @JsonIgnore
        @OneToOne(mappedBy = "growth", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
        private Species species;

        public Growth() {
        }

        public Species getSpecies() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species = species;
        }

        public void setMinimumTemperatureDegF(Float minimumTemperatureDegF) {
        }

        public void setMinimumTemperatureDegC(Float minimumTemperatureDegC) {
        }

        public void setMaximumTemperatureDegF(Float maximumTemperatureDegF) {
        }

        public void setMaximumTemperatureDegC(Float maximumTemperatureDegC) {
        }

        public void setRowSpacingCm(Float rowSpacingCm) {
        }

        public void setSpreadCm(Float spreadCm) {
        }

        public void setMinimumPrecipitationMm(Float minimumPrecipitationMm) {
        }

        public void setMaximumPrecipitationMm(Float maximumPrecipitationMm) {
        }

        public void setMinimumRootDepthCm(Float minimumRootDepthCm) {
        }

        @Column(name = "row_spacing_cm")
        @Access(AccessType.PROPERTY)
        public Float getRowSpacingCm() {
            if (this.getRowSpacing() == null) {
                return null;
            }
            return this.getRowSpacing().getCm();
        }

        @Column(name = "spread_cm")
        @Access(AccessType.PROPERTY)
        public Float getSpreadCm() {
            if (this.getSpread() == null) {
                return null;
            }
            return this.getSpread().getCm();
        }

        @Column(name = "min_precip_mm")
        @Access(AccessType.PROPERTY)
        public Float getMinimumPrecipitationMm() {
            if (this.getMinimumPrecipitation() == null) {
                return null;
            }
            return this.getMinimumPrecipitation().getMm();
        }

        @Column(name = "max_precip_mm")
        @Access(AccessType.PROPERTY)
        public Float getMaximumPrecipitationMm() {
            if (this.getMaximumPrecipitation() == null) {
                return null;
            }
            return this.getMaximumPrecipitation().getMm();
        }

        @Column(name = "min_root_depth")
        @Access(AccessType.PROPERTY)
        public Float getMinimumRootDepthCm() {
            if (this.getMinimumRootDepth() == null) {
                return null;
            }
            return this.getMinimumRootDepth().getCm();
        }

        @Column(name = "min_temp_F")
        @Access(AccessType.PROPERTY)
        public Float getMinimumTemperatureDegF() {
            if (this.getMinimumTemperature() == null) {
                return null;
            }
            return this.getMinimumTemperature().getDegF();
        }

        @Column(name = "min_temp_C")
        @Access(AccessType.PROPERTY)
        public Float getMinimumTemperatureDegC() {
            if (this.getMinimumTemperature() == null) {
                return null;
            }
            return this.getMinimumTemperature().getDegC();
        }

        @Column(name = "max_temp_F")
        @Access(AccessType.PROPERTY)
        public Float getMaximumTemperatureDegF() {
            if (this.getMaximumTemperature() == null) {
                return null;
            }
            return this.getMaximumTemperature().getDegF();
        }

        @Column(name = "max_temp_C")
        @Access(AccessType.PROPERTY)
        public Float getMaximumTemperatureDegC() {
            if (this.getMaximumTemperature() == null) {
                return null;
            }
            return this.getMaximumTemperature().getDegC();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

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
        public Float getDaysToHarvest() {
            return daysToHarvest;
        }

        public void setDaysToHarvest(Float daysToHarvest) {
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
        public List<Month> getGrowthMonths() {
            return growthMonths;
        }

        public void setGrowthMonths(List<Month> growthMonths) {
            this.growthMonths = growthMonths;
        }

        @JsonProperty("bloom_months")
        public List<Month> getBloomMonths() {
            return bloomMonths;
        }

        public void setBloomMonths(List<Month> bloomMonths) {
            this.bloomMonths = bloomMonths;
        }

        @JsonProperty("fruit_months")
        public List<Month> getFruitMonths() {
            return fruitMonths;
        }

        public void setFruitMonths(List<Month> fruitMonths) {
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

        public enum Month {
            JANUARY ("jan"),
            FEBRUARY ("feb"),
            MARCH ("mar"),
            APRIL ("apr"),
            MAY ("may"),
            JUNE ("jun"),
            JULY ("jul"),
            AUGUST ("aug"),
            SEPTEMBER ("sep"),
            OCTOBER ("oct"),
            NOVEMBER ("nov"),
            DECEMBER ("dec");

            private final String month;

            Month(String month) {
                this.month = month;
            }

            @JsonValue
            public String getMonth() {
                return this.month;
            }
        }

        public static class Temperature {
            @JsonProperty("deg_f")
            private Float degF;
            @JsonProperty("deg_c")
            private Float degC;

            @JsonProperty("deg_f")
            public Float getDegF() {
                return degF;
            }

            public void setDegF(Float degF) {
                this.degF = degF;
            }

            @JsonProperty("deg_c")
            public Float getDegC() {
                return degC;
            }

            public void setDegC(Float degC) {
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
    }

    @Entity
    @Table(name = "specifications")
    @Access(AccessType.FIELD)
    public static class Specifications {
        @Id
        @GeneratedValue
        @JsonIgnore
        private Integer id;
        @JsonProperty("ligneous_type")
        @Enumerated(EnumType.STRING)
        private LigneousType ligneousType;
        @JsonProperty("growth_form")
        private String growthForm;
        @JsonProperty("growth_habit")
        private String growthHabit;
        @JsonProperty("growth_rate")
        private String growthRate;
        @JsonProperty("average_height")
        @Transient
        private LinearMeasurementCm averageHeight;
        @JsonProperty("maximum_height")
        @Transient
        private LinearMeasurementCm maximumHeight;
        @JsonProperty("nitrogen_fixation")
        private String nitrogenFixation;
        @JsonProperty("shape_and_orientation")
        private String shapeAndOrientation;
        @Enumerated(EnumType.STRING)
        private Toxicity toxicity;
        @JsonIgnore
        @OneToOne(mappedBy = "specifications", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
        private Species species;

        public Specifications() {}

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Column(name = "avg_height_cm")
        @Access(AccessType.PROPERTY)
        public Float getAverageHeightCm() {
            if (this.getAverageHeight() == null) {
                return null;
            }
            return this.getAverageHeight().getCm();
        }
        public void setAverageHeightCm(Integer averageHeightCm) {}

        @Column(name = "max_height_cm")
        @Access(AccessType.PROPERTY)
        public Float getMaximumHeightCm() {
            if (this.getMaximumHeight() == null) {
                return null;
            }
            return this.getMaximumHeight().getCm();
        }
        public void setMaximumHeightCm(Integer maximumHeightCm) {}

        @JsonProperty("ligneous_type")
        public LigneousType getLigneousType() {
            return ligneousType;
        }

        public void setLigneousType(LigneousType ligneousType) {
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

        public Toxicity getToxicity() {
            return toxicity;
        }

        public void setToxicity(Toxicity toxicity) {
            this.toxicity = toxicity;
        }

        public Species getSpecies() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species = species;
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

        public enum LigneousType {
            LIANA ("liana"),
            SUBSHRUB ("subshrub"),
            SHRUB ("shrub"),
            TREE ("tree"),
            PARASITE ("parasite");

            private final String type;

            LigneousType(String type) {
                this.type = type;
            }

            @JsonValue
            public String getType() {
                return this.type;
            }
        }

        public enum Toxicity {
            NONE ("none"),
            LOW ("low"),
            MEDIUM ("medium"),
            HIGH ("high");

            private final String level;

            Toxicity(String level) {
                this.level = level;
            }

            @JsonValue
            public String getLevel() {
                return this.level;
            }
        }
    }

    @Entity
    public static class Synonym {
        @Id
        private Integer id;
        private String name;
        private String author;

        public Synonym() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

    }

    @Embeddable
    public static class CommonNames {
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> en;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> ar;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> an;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> hy;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> az;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> eu;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> be;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> bg;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> ca;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> cv;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> hr;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> cs;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> da;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> nl;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> eo;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> et;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> fi;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> fr;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> gl;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> ka;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> de;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> he;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> hu;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        @Column(name = "lang_is")
        private List<String> is;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> it;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> kk;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> lv;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> lt;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> mk;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> gv;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> se;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> no;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> nb;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> nn;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> oc;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> fa;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> pl;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> pt;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> ru;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> sr;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> sk;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> sl;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> es;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> sv;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> tr;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> uk;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> wa;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> cy;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> fin;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> swe;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> dan;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> deu;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> eng;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> nno;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> nob;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> fra;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> por;
        @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
        private List<String> nld;

        public CommonNames() {}

        public List<String> getEn() {
            return en;
        }

        public void setEn(List<String> en) {
            this.en = en;
        }

        public List<String> getAr() {
            return ar;
        }

        public void setAr(List<String> ar) {
            this.ar = ar;
        }

        public List<String> getAn() {
            return an;
        }

        public void setAn(List<String> an) {
            this.an = an;
        }

        public List<String> getHy() {
            return hy;
        }

        public void setHy(List<String> hy) {
            this.hy = hy;
        }

        public List<String> getAz() {
            return az;
        }

        public void setAz(List<String> az) {
            this.az = az;
        }

        public List<String> getEu() {
            return eu;
        }

        public void setEu(List<String> eu) {
            this.eu = eu;
        }

        public List<String> getBe() {
            return be;
        }

        public void setBe(List<String> be) {
            this.be = be;
        }

        public List<String> getBg() {
            return bg;
        }

        public void setBg(List<String> bg) {
            this.bg = bg;
        }

        public List<String> getCa() {
            return ca;
        }

        public void setCa(List<String> ca) {
            this.ca = ca;
        }

        public List<String> getCv() {
            return cv;
        }

        public void setCv(List<String> cv) {
            this.cv = cv;
        }

        public List<String> getHr() {
            return hr;
        }

        public void setHr(List<String> hr) {
            this.hr = hr;
        }

        public List<String> getCs() {
            return cs;
        }

        public void setCs(List<String> cs) {
            this.cs = cs;
        }

        public List<String> getDa() {
            return da;
        }

        public void setDa(List<String> da) {
            this.da = da;
        }

        public List<String> getNl() {
            return nl;
        }

        public void setNl(List<String> nl) {
            this.nl = nl;
        }

        public List<String> getEo() {
            return eo;
        }

        public void setEo(List<String> eo) {
            this.eo = eo;
        }

        public List<String> getEt() {
            return et;
        }

        public void setEt(List<String> et) {
            this.et = et;
        }

        public List<String> getFi() {
            return fi;
        }

        public void setFi(List<String> fi) {
            this.fi = fi;
        }

        public List<String> getFr() {
            return fr;
        }

        public void setFr(List<String> fr) {
            this.fr = fr;
        }

        public List<String> getGl() {
            return gl;
        }

        public void setGl(List<String> gl) {
            this.gl = gl;
        }

        public List<String> getKa() {
            return ka;
        }

        public void setKa(List<String> ka) {
            this.ka = ka;
        }

        public List<String> getDe() {
            return de;
        }

        public void setDe(List<String> de) {
            this.de = de;
        }

        public List<String> getHe() {
            return he;
        }

        public void setHe(List<String> he) {
            this.he = he;
        }

        public List<String> getHu() {
            return hu;
        }

        public void setHu(List<String> hu) {
            this.hu = hu;
        }

        public List<String> getIs() {
            return is;
        }

        public void setIs(List<String> is) {
            this.is = is;
        }

        public List<String> getIt() {
            return it;
        }

        public void setIt(List<String> it) {
            this.it = it;
        }

        public List<String> getKk() {
            return kk;
        }

        public void setKk(List<String> kk) {
            this.kk = kk;
        }

        public List<String> getLv() {
            return lv;
        }

        public void setLv(List<String> lv) {
            this.lv = lv;
        }

        public List<String> getLt() {
            return lt;
        }

        public void setLt(List<String> lt) {
            this.lt = lt;
        }

        public List<String> getMk() {
            return mk;
        }

        public void setMk(List<String> mk) {
            this.mk = mk;
        }

        public List<String> getGv() {
            return gv;
        }

        public void setGv(List<String> gv) {
            this.gv = gv;
        }

        public List<String> getSe() {
            return se;
        }

        public void setSe(List<String> se) {
            this.se = se;
        }

        public List<String> getNo() {
            return no;
        }

        public void setNo(List<String> no) {
            this.no = no;
        }

        public List<String> getNb() {
            return nb;
        }

        public void setNb(List<String> nb) {
            this.nb = nb;
        }

        public List<String> getNn() {
            return nn;
        }

        public void setNn(List<String> nn) {
            this.nn = nn;
        }

        public List<String> getOc() {
            return oc;
        }

        public void setOc(List<String> oc) {
            this.oc = oc;
        }

        public List<String> getFa() {
            return fa;
        }

        public void setFa(List<String> fa) {
            this.fa = fa;
        }

        public List<String> getPl() {
            return pl;
        }

        public void setPl(List<String> pl) {
            this.pl = pl;
        }

        public List<String> getPt() {
            return pt;
        }

        public void setPt(List<String> pt) {
            this.pt = pt;
        }

        public List<String> getRu() {
            return ru;
        }

        public void setRu(List<String> ru) {
            this.ru = ru;
        }

        public List<String> getSr() {
            return sr;
        }

        public void setSr(List<String> sr) {
            this.sr = sr;
        }

        public List<String> getSk() {
            return sk;
        }

        public void setSk(List<String> sk) {
            this.sk = sk;
        }

        public List<String> getSl() {
            return sl;
        }

        public void setSl(List<String> sl) {
            this.sl = sl;
        }

        public List<String> getEs() {
            return es;
        }

        public void setEs(List<String> es) {
            this.es = es;
        }

        public List<String> getSv() {
            return sv;
        }

        public void setSv(List<String> sv) {
            this.sv = sv;
        }

        public List<String> getTr() {
            return tr;
        }

        public void setTr(List<String> tr) {
            this.tr = tr;
        }

        public List<String> getUk() {
            return uk;
        }

        public void setUk(List<String> uk) {
            this.uk = uk;
        }

        public List<String> getWa() {
            return wa;
        }

        public void setWa(List<String> wa) {
            this.wa = wa;
        }

        public List<String> getCy() {
            return cy;
        }

        public void setCy(List<String> cy) {
            this.cy = cy;
        }

        public List<String> getFin() {
            return fin;
        }

        public void setFin(List<String> fin) {
            this.fin = fin;
        }

        public List<String> getSwe() {
            return swe;
        }

        public void setSwe(List<String> swe) {
            this.swe = swe;
        }

        public List<String> getDan() {
            return dan;
        }

        public void setDan(List<String> dan) {
            this.dan = dan;
        }

        public List<String> getDeu() {
            return deu;
        }

        public void setDeu(List<String> deu) {
            this.deu = deu;
        }

        public List<String> getEng() {
            return eng;
        }

        public void setEng(List<String> eng) {
            this.eng = eng;
        }

        public List<String> getNno() {
            return nno;
        }

        public void setNno(List<String> nno) {
            this.nno = nno;
        }

        public List<String> getNob() {
            return nob;
        }

        public void setNob(List<String> nob) {
            this.nob = nob;
        }

        public List<String> getFra() {
            return fra;
        }

        public void setFra(List<String> fra) {
            this.fra = fra;
        }

        public List<String> getPor() {
            return por;
        }

        public void setPor(List<String> por) {
            this.por = por;
        }

        public List<String> getNld() {
            return nld;
        }

        public void setNld(List<String> nld) {
            this.nld = nld;
        }

        @Override
        public String toString() {
            return "CommonNames{" +
                    "en=" + en +
                    ", ar=" + ar +
                    ", an=" + an +
                    ", hy=" + hy +
                    ", az=" + az +
                    ", eu=" + eu +
                    ", be=" + be +
                    ", bg=" + bg +
                    ", ca=" + ca +
                    ", cv=" + cv +
                    ", hr=" + hr +
                    ", cs=" + cs +
                    ", da=" + da +
                    ", nl=" + nl +
                    ", eo=" + eo +
                    ", et=" + et +
                    ", fi=" + fi +
                    ", fr=" + fr +
                    ", gl=" + gl +
                    ", ka=" + ka +
                    ", de=" + de +
                    ", he=" + he +
                    ", hu=" + hu +
                    ", is=" + is +
                    ", it=" + it +
                    ", kk=" + kk +
                    ", lv=" + lv +
                    ", lt=" + lt +
                    ", mk=" + mk +
                    ", gv=" + gv +
                    ", se=" + se +
                    ", no=" + no +
                    ", nb=" + nb +
                    ", nn=" + nn +
                    ", oc=" + oc +
                    ", fa=" + fa +
                    ", pl=" + pl +
                    ", pt=" + pt +
                    ", ru=" + ru +
                    ", sr=" + sr +
                    ", sk=" + sk +
                    ", sl=" + sl +
                    ", es=" + es +
                    ", sv=" + sv +
                    ", tr=" + tr +
                    ", uk=" + uk +
                    ", wa=" + wa +
                    ", cy=" + cy +
                    ", fin=" + fin +
                    ", swe=" + swe +
                    ", dan=" + dan +
                    ", deu=" + deu +
                    ", eng=" + eng +
                    ", nno=" + nno +
                    ", nob=" + nob +
                    ", fra=" + fra +
                    ", por=" + por +
                    ", nld=" + nld +
                    '}';
        }
    }

    public enum Duration {
        ANNUAL ("annual"),
        PERENNIAL ("perennial"),
        BIENNIAL ("biennial");

        private final String duration;

        Duration(String duration) {
            this.duration = duration;
        }

        @JsonValue
        private String getDuration() {
            return this.duration;
        }
    }

    public enum EdiblePart {
        ROOTS ("roots"),
        STEM ("stem"),
        LEAVES ("leaves"),
        FLOWERS ("flowers"),
        FRUITS ("fruits"),
        SEEDS ("seeds"),
        TUBERS ("tubers");

        private final String part;

        EdiblePart(String part) {
            this.part = part;
        }

        @JsonValue
        private String getPart() {
            return this.part;
        }
    }

    @Entity
    @Table(name = "flower")
    public static class Flower {
        @Id
        @GeneratedValue
        @JsonIgnore
        private Integer id;
        @ElementCollection
        @CollectionTable(name = "flower_colors", joinColumns = {
                @JoinColumn(name = "flower_id")
        })
        @Enumerated(EnumType.STRING)
        private List<Color> color;
        private Boolean conspicuous;
        @JsonIgnore
        @OneToOne(mappedBy = "flower",
                cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
        private Species species;

        public Flower() {}

        public List<Color> getColor() {
            return color;
        }

        public void setColor(List<Color> color) {
            this.color = color;
        }

        public Boolean getConspicuous() {
            return conspicuous;
        }

        public void setConspicuous(Boolean conspicuous) {
            this.conspicuous = conspicuous;
        }

        public Species getSpecies() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species = species;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "color='" + color + '\'' +
                    ", conspicuous=" + conspicuous +
                    '}';
        }
    }

    @Entity
    @Table(name = "foliage")
    public static class Foliage {
        @Id
        @GeneratedValue
        @JsonIgnore
        private Integer id;
        private Texture texture;
        @ElementCollection
        @CollectionTable(name = "foliage_colors", joinColumns = {
                @JoinColumn(name = "foliage_id")
        })
        @Enumerated(EnumType.STRING)
        private List<Color> color;
        @JsonProperty("leaf_retention")
        private Boolean leafRetention;
        @JsonIgnore
        @OneToOne(mappedBy = "foliage", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
        private Species species;

        public Foliage() {}

        public Texture getTexture() {
            return texture;
        }

        public void setTexture(Texture texture) {
            this.texture = texture;
        }

        public List<Color> getColor() {
            return color;
        }

        public void setColor(List<Color> color) {
            this.color = color;
        }

        @JsonProperty("leaf_retention")
        public Boolean getLeafRetention() {
            return leafRetention;
        }

        public void setLeafRetention(Boolean leafRetention) {
            this.leafRetention = leafRetention;
        }

        public Species getSpecies() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species = species;
        }

        @Override
        public String toString() {
            return "Foliage{" +
                    "texture='" + texture + '\'' +
                    ", color='" + color + '\'' +
                    ", leafRetention=" + leafRetention +
                    '}';
        }

        public enum Texture {
            FINE ("fine"),
            MEDIUM ("medium"),
            COARSE ("coarse");

            private final String texture;

            Texture(String texture) {
                this.texture = texture;
            }

            @JsonValue
            public String getTexture() {
                return texture;
            }
        }
    }

    @Entity
    @Table(name = "fruit_or_seed")
    public static class FruitOrSeed {
        @Id
        @GeneratedValue
        @JsonIgnore
        private Integer id;
        private Boolean conspicuous;
        @ElementCollection
        @CollectionTable(name = "fruit_or_seed_colors", joinColumns = {
                @JoinColumn(name = "fruit_or_seed_id")
        })
        @Enumerated(EnumType.STRING)
        private List<Color> color;
        private String shape;
        @JsonProperty("seed_persistence")
        private Boolean seedPersistence;
        @JsonIgnore
        @OneToOne(mappedBy = "fruitOrSeed", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
        private Species species;

        public FruitOrSeed() {}

        public Boolean getConspicuous() {
            return conspicuous;
        }

        public void setConspicuous(Boolean conspicuous) {
            this.conspicuous = conspicuous;
        }

        public List<Color> getColor() {
            return color;
        }

        public void setColor(List<Color> color) {
            this.color = color;
        }

        public String getShape() {
            return shape;
        }

        public void setShape(String shape) {
            this.shape = shape;
        }

        @JsonProperty("seed_persistence")
        public Boolean getSeedPersistence() {
            return seedPersistence;
        }

        public void setSeedPersistence(Boolean seedPersistence) {
            this.seedPersistence = seedPersistence;
        }

        public Species getSpecies() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species = species;
        }

        @Override
        public String toString() {
            return "FruitOrSeed{" +
                    "conspicuous=" + conspicuous +
                    ", color='" + color + '\'' +
                    ", shape='" + shape + '\'' +
                    ", seedPersistence=" + seedPersistence +
                    '}';
        }
    }

    public enum Color {
        WHITE ("white"),
        RED ("red"),
        BROWN ("brown"),
        ORANGE ("orange"),
        YELLOW ("yellow"),
        LIME ("lime"),
        GREEN ("green"),
        CYAN ("cyan"),
        BLUE ("blue"),
        PURPLE ("purple"),
        MAGENTA ("magenta"),
        GREY ("grey"),
        BLACK ("black");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        @JsonValue
        public String getColor() {
            return color;
        }
    }

    public static class LinearMeasurementMm {
        private Float mm;

        public Float getMm() {
            return mm;
        }

        public void setMm(Float mm) {
            this.mm = mm;
        }

        @Override
        public String toString() {
            return "LinearMeasurementMm{" +
                    "mm=" + mm +
                    '}';
        }
    }

    public static class LinearMeasurementCm {
        private Float cm;

        public Float getCm() {
            return cm;
        }

        public void setCm(Float cm) {
            this.cm = cm;
        }

        @Override
        public String toString() {
            return "LinearMeasurementCm{" +
                    "cm=" + cm +
                    '}';
        }
    }
}
