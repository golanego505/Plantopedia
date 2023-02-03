package org.launchcode.plantopedia.models.distributions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Distributions {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    @JsonProperty("native")
    @ElementCollection(fetch = FetchType.LAZY, targetClass = TdwgUnit.class)
    private List<TdwgUnit> ntv;
    @ElementCollection(fetch = FetchType.LAZY, targetClass = TdwgUnit.class)
    private List<TdwgUnit> introduced;
    @ElementCollection(fetch = FetchType.LAZY, targetClass = TdwgUnit.class)
    private List<TdwgUnit> doubtful;
    @ElementCollection(fetch = FetchType.LAZY, targetClass = TdwgUnit.class)
    private List<TdwgUnit> absent;
    @ElementCollection(fetch = FetchType.LAZY, targetClass = TdwgUnit.class)
    private List<TdwgUnit> extinct;

    public Distributions() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("native")
    public List<TdwgUnit> getNtv() {
        return ntv;
    }

    public void setNtv(List<TdwgUnit> ntv) {
        this.ntv = ntv;
    }

    public List<TdwgUnit> getIntroduced() {
        return introduced;
    }

    public void setIntroduced(List<TdwgUnit> introduced) {
        this.introduced = introduced;
    }

    public List<TdwgUnit> getDoubtful() {
        return doubtful;
    }

    public void setDoubtful(List<TdwgUnit> doubtful) {
        this.doubtful = doubtful;
    }

    public List<TdwgUnit> getAbsent() {
        return absent;
    }

    public void setAbsent(List<TdwgUnit> absent) {
        this.absent = absent;
    }

    public List<TdwgUnit> getExtinct() {
        return extinct;
    }

    public void setExtinct(List<TdwgUnit> extinct) {
        this.extinct = extinct;
    }

    @Override
    public String toString() {
        return "Distributions{" +
                "id=" + id +
                ", ntv=" + ntv +
                ", introduced=" + introduced +
                ", doubtful=" + doubtful +
                ", absent=" + absent +
                ", extinct=" + extinct +
                '}';
    }
}
