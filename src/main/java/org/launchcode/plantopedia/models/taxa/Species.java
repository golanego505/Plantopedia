package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.launchcode.plantopedia.models.*;
import org.launchcode.plantopedia.models.distributions.Distribution;
import org.launchcode.plantopedia.models.distributions.Distributions;
import org.launchcode.plantopedia.models.measurements.LinearMeasurementCm;
import org.launchcode.plantopedia.models.measurements.LinearMeasurementMm;
import org.launchcode.plantopedia.models.measurements.Temperature;
import org.launchcode.plantopedia.models.presentations.Flower;
import org.launchcode.plantopedia.models.presentations.Foliage;
import org.launchcode.plantopedia.models.presentations.FruitOrSeed;

import java.util.ArrayList;
import java.util.List;

public class Species extends PlantSpecies {
    private String observations;
    private Boolean vegetable;
    private String duration;
    @JsonProperty("edible_part")
    private String ediblePart;
    private Boolean edible;
    private Images images;
    @JsonProperty("common_names")
    private CommonNames commonNames;
    private Distribution distribution;
    private Distributions distributions;
    private Flower flower;
    private Foliage foliage;
    @JsonProperty("fruit_or_seed")
    private FruitOrSeed fruitOrSeed;
    private Specifications specifications;
    private Growth growth;
    private List<Synonym> synonyms;
    private List<Source> sources;

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
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("edible_part")
    public String getEdiblePart() {
        return ediblePart;
    }

    public void setEdiblePart(String ediblePart) {
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

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
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

    public List<Source> getSources() {
        return sources;
    }
    public void setSources(List<Source> sources) {
        this.sources = sources;
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
                ", distribution=" + distribution +
                ", distributions=" + distributions +
                ", flower=" + flower +
                ", foliage=" + foliage +
                ", fruitOrSeed=" + fruitOrSeed +
                ", specifications=" + specifications +
                ", growth=" + growth +
                ", links=" + this.getLinks() +
                ", synonyms=" + synonyms +
                ", sources=" + sources +
                '}';
    }

    public static class Images {
        private List<Image> flower;
        private List<Image> leaf;
        private List<Image> habit;
        private List<Image> fruit;
        private List<Image> bark;
        private List<Image> other;

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
        public static class Image {
            @Id
            private Integer id;
            @JsonProperty("image_url")
            private String imageUrl;
            private String copyright;

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

    public static class Growth {
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

    public static class Specifications {
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

    public static class Synonym {
        private Integer id;
        private String name;
        private String author;
        private List<Source> sources;

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

        public List<Source> getSources() {
            return sources;
        }

        public void setSources(List<Source> sources) {
            this.sources = sources;
        }
    }

    public static class CommonNames {
        private ArrayList<String> en;
        private ArrayList<String> ar;
        private ArrayList<String> an;
        private ArrayList<String> hy;
        private ArrayList<String> az;
        private ArrayList<String> eu;
        private ArrayList<String> be;
        private ArrayList<String> bg;
        private ArrayList<String> ca;
        private ArrayList<String> cv;
        private ArrayList<String> hr;
        private ArrayList<String> cs;
        private ArrayList<String> da;
        private ArrayList<String> nl;
        private ArrayList<String> eo;
        private ArrayList<String> et;
        private ArrayList<String> fi;
        private ArrayList<String> fr;
        private ArrayList<String> gl;
        private ArrayList<String> ka;
        private ArrayList<String> de;
        private ArrayList<String> he;
        private ArrayList<String> hu;
        private ArrayList<String> is;
        private ArrayList<String> it;
        private ArrayList<String> kk;
        private ArrayList<String> lv;
        private ArrayList<String> lt;
        private ArrayList<String> mk;
        private ArrayList<String> gv;
        private ArrayList<String> se;
        private ArrayList<String> no;
        private ArrayList<String> nb;
        private ArrayList<String> nn;
        private ArrayList<String> oc;
        private ArrayList<String> fa;
        private ArrayList<String> pl;
        private ArrayList<String> pt;
        private ArrayList<String> ru;
        private ArrayList<String> sr;
        private ArrayList<String> sk;
        private ArrayList<String> sl;
        private ArrayList<String> es;
        private ArrayList<String> sv;
        private ArrayList<String> tr;
        private ArrayList<String> uk;
        private ArrayList<String> wa;
        private ArrayList<String> cy;
        private ArrayList<String> fin;
        private ArrayList<String> swe;
        private ArrayList<String> dan;
        private ArrayList<String> deu;
        private ArrayList<String> eng;
        private ArrayList<String> nno;
        private ArrayList<String> nob;
        private ArrayList<String> fra;
        private ArrayList<String> por;
        private ArrayList<String> nld;

        public ArrayList<String> getEn() {
            return en;
        }

        public void setEn(ArrayList<String> en) {
            this.en = en;
        }

        public ArrayList<String> getAr() {
            return ar;
        }

        public void setAr(ArrayList<String> ar) {
            this.ar = ar;
        }

        public ArrayList<String> getAn() {
            return an;
        }

        public void setAn(ArrayList<String> an) {
            this.an = an;
        }

        public ArrayList<String> getHy() {
            return hy;
        }

        public void setHy(ArrayList<String> hy) {
            this.hy = hy;
        }

        public ArrayList<String> getAz() {
            return az;
        }

        public void setAz(ArrayList<String> az) {
            this.az = az;
        }

        public ArrayList<String> getEu() {
            return eu;
        }

        public void setEu(ArrayList<String> eu) {
            this.eu = eu;
        }

        public ArrayList<String> getBe() {
            return be;
        }

        public void setBe(ArrayList<String> be) {
            this.be = be;
        }

        public ArrayList<String> getBg() {
            return bg;
        }

        public void setBg(ArrayList<String> bg) {
            this.bg = bg;
        }

        public ArrayList<String> getCa() {
            return ca;
        }

        public void setCa(ArrayList<String> ca) {
            this.ca = ca;
        }

        public ArrayList<String> getCv() {
            return cv;
        }

        public void setCv(ArrayList<String> cv) {
            this.cv = cv;
        }

        public ArrayList<String> getHr() {
            return hr;
        }

        public void setHr(ArrayList<String> hr) {
            this.hr = hr;
        }

        public ArrayList<String> getCs() {
            return cs;
        }

        public void setCs(ArrayList<String> cs) {
            this.cs = cs;
        }

        public ArrayList<String> getDa() {
            return da;
        }

        public void setDa(ArrayList<String> da) {
            this.da = da;
        }

        public ArrayList<String> getNl() {
            return nl;
        }

        public void setNl(ArrayList<String> nl) {
            this.nl = nl;
        }

        public ArrayList<String> getEo() {
            return eo;
        }

        public void setEo(ArrayList<String> eo) {
            this.eo = eo;
        }

        public ArrayList<String> getEt() {
            return et;
        }

        public void setEt(ArrayList<String> et) {
            this.et = et;
        }

        public ArrayList<String> getFi() {
            return fi;
        }

        public void setFi(ArrayList<String> fi) {
            this.fi = fi;
        }

        public ArrayList<String> getFr() {
            return fr;
        }

        public void setFr(ArrayList<String> fr) {
            this.fr = fr;
        }

        public ArrayList<String> getGl() {
            return gl;
        }

        public void setGl(ArrayList<String> gl) {
            this.gl = gl;
        }

        public ArrayList<String> getKa() {
            return ka;
        }

        public void setKa(ArrayList<String> ka) {
            this.ka = ka;
        }

        public ArrayList<String> getDe() {
            return de;
        }

        public void setDe(ArrayList<String> de) {
            this.de = de;
        }

        public ArrayList<String> getHe() {
            return he;
        }

        public void setHe(ArrayList<String> he) {
            this.he = he;
        }

        public ArrayList<String> getHu() {
            return hu;
        }

        public void setHu(ArrayList<String> hu) {
            this.hu = hu;
        }

        public ArrayList<String> getIs() {
            return is;
        }

        public void setIs(ArrayList<String> is) {
            this.is = is;
        }

        public ArrayList<String> getIt() {
            return it;
        }

        public void setIt(ArrayList<String> it) {
            this.it = it;
        }

        public ArrayList<String> getKk() {
            return kk;
        }

        public void setKk(ArrayList<String> kk) {
            this.kk = kk;
        }

        public ArrayList<String> getLv() {
            return lv;
        }

        public void setLv(ArrayList<String> lv) {
            this.lv = lv;
        }

        public ArrayList<String> getLt() {
            return lt;
        }

        public void setLt(ArrayList<String> lt) {
            this.lt = lt;
        }

        public ArrayList<String> getMk() {
            return mk;
        }

        public void setMk(ArrayList<String> mk) {
            this.mk = mk;
        }

        public ArrayList<String> getGv() {
            return gv;
        }

        public void setGv(ArrayList<String> gv) {
            this.gv = gv;
        }

        public ArrayList<String> getSe() {
            return se;
        }

        public void setSe(ArrayList<String> se) {
            this.se = se;
        }

        public ArrayList<String> getNo() {
            return no;
        }

        public void setNo(ArrayList<String> no) {
            this.no = no;
        }

        public ArrayList<String> getNb() {
            return nb;
        }

        public void setNb(ArrayList<String> nb) {
            this.nb = nb;
        }

        public ArrayList<String> getNn() {
            return nn;
        }

        public void setNn(ArrayList<String> nn) {
            this.nn = nn;
        }

        public ArrayList<String> getOc() {
            return oc;
        }

        public void setOc(ArrayList<String> oc) {
            this.oc = oc;
        }

        public ArrayList<String> getFa() {
            return fa;
        }

        public void setFa(ArrayList<String> fa) {
            this.fa = fa;
        }

        public ArrayList<String> getPl() {
            return pl;
        }

        public void setPl(ArrayList<String> pl) {
            this.pl = pl;
        }

        public ArrayList<String> getPt() {
            return pt;
        }

        public void setPt(ArrayList<String> pt) {
            this.pt = pt;
        }

        public ArrayList<String> getRu() {
            return ru;
        }

        public void setRu(ArrayList<String> ru) {
            this.ru = ru;
        }

        public ArrayList<String> getSr() {
            return sr;
        }

        public void setSr(ArrayList<String> sr) {
            this.sr = sr;
        }

        public ArrayList<String> getSk() {
            return sk;
        }

        public void setSk(ArrayList<String> sk) {
            this.sk = sk;
        }

        public ArrayList<String> getSl() {
            return sl;
        }

        public void setSl(ArrayList<String> sl) {
            this.sl = sl;
        }

        public ArrayList<String> getEs() {
            return es;
        }

        public void setEs(ArrayList<String> es) {
            this.es = es;
        }

        public ArrayList<String> getSv() {
            return sv;
        }

        public void setSv(ArrayList<String> sv) {
            this.sv = sv;
        }

        public ArrayList<String> getTr() {
            return tr;
        }

        public void setTr(ArrayList<String> tr) {
            this.tr = tr;
        }

        public ArrayList<String> getUk() {
            return uk;
        }

        public void setUk(ArrayList<String> uk) {
            this.uk = uk;
        }

        public ArrayList<String> getWa() {
            return wa;
        }

        public void setWa(ArrayList<String> wa) {
            this.wa = wa;
        }

        public ArrayList<String> getCy() {
            return cy;
        }

        public void setCy(ArrayList<String> cy) {
            this.cy = cy;
        }

        public ArrayList<String> getFin() {
            return fin;
        }

        public void setFin(ArrayList<String> fin) {
            this.fin = fin;
        }

        public ArrayList<String> getSwe() {
            return swe;
        }

        public void setSwe(ArrayList<String> swe) {
            this.swe = swe;
        }

        public ArrayList<String> getDan() {
            return dan;
        }

        public void setDan(ArrayList<String> dan) {
            this.dan = dan;
        }

        public ArrayList<String> getDeu() {
            return deu;
        }

        public void setDeu(ArrayList<String> deu) {
            this.deu = deu;
        }

        public ArrayList<String> getEng() {
            return eng;
        }

        public void setEng(ArrayList<String> eng) {
            this.eng = eng;
        }

        public ArrayList<String> getNno() {
            return nno;
        }

        public void setNno(ArrayList<String> nno) {
            this.nno = nno;
        }

        public ArrayList<String> getNob() {
            return nob;
        }

        public void setNob(ArrayList<String> nob) {
            this.nob = nob;
        }

        public ArrayList<String> getFra() {
            return fra;
        }

        public void setFra(ArrayList<String> fra) {
            this.fra = fra;
        }

        public ArrayList<String> getPor() {
            return por;
        }

        public void setPor(ArrayList<String> por) {
            this.por = por;
        }

        public ArrayList<String> getNld() {
            return nld;
        }

        public void setNld(ArrayList<String> nld) {
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
}
