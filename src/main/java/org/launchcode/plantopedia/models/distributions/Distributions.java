package org.launchcode.plantopedia.models.distributions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Distributions {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    @JsonProperty("native")
    @ElementCollection(fetch = FetchType.LAZY, targetClass = DistributionZone.class)
    private ArrayList<DistributionZone> ntv;
    @ElementCollection(fetch = FetchType.LAZY, targetClass = DistributionZone.class)
    private ArrayList<DistributionZone> introduced;

    public Distributions() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("native")
    public ArrayList<DistributionZone> getNtv() {
        return ntv;
    }

    public void setNtv(ArrayList<DistributionZone> ntv) {
        this.ntv = ntv;
    }

    public ArrayList<DistributionZone> getIntroduced() {
        return introduced;
    }

    public void setIntroduced(ArrayList<DistributionZone> introduced) {
        this.introduced = introduced;
    }

    @Override
    public String toString() {
        return "Distributions{" +
                "ntv=" + ntv +
                ", introduced=" + introduced +
                '}';
    }
}
