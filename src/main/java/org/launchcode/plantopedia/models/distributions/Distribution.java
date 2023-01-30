package org.launchcode.plantopedia.models.distributions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Distribution {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    @JsonProperty("native")
    @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
    private ArrayList<String> ntv;
    @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
    private ArrayList<String> introduced;

    public Distribution() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("native")
    public ArrayList<String> getNtv() {
        return ntv;
    }

    public void setNtv(ArrayList<String> ntv) {
        this.ntv = ntv;
    }

    public ArrayList<String> getIntroduced() {
        return introduced;
    }

    public void setIntroduced(ArrayList<String> introduced) {
        this.introduced = introduced;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "ntv=" + ntv +
                ", introduced=" + introduced +
                '}';
    }
}
