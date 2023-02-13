package org.launchcode.plantopedia.models.distributions;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class Distributions {
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "native_distributions",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "tdwg_unit_id")
    )
    private List<TdwgUnit> ntv;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "introduced_distributions",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "tdwg_unit_id")
    )
    private List<TdwgUnit> introduced;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "doubtful_distributions",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "tdwg_unit_id")
    )
    private List<TdwgUnit> doubtful;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "absent_distributions",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "tdwg_unit_id")
    )
    private List<TdwgUnit> absent;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "extinct_distributions",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "tdwg_unit_id")
    )
    private List<TdwgUnit> extinct;

    public Distributions() {}

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
//                "id=" + id +
                ", ntv=" + ntv +
                ", introduced=" + introduced +
                ", doubtful=" + doubtful +
                ", absent=" + absent +
                ", extinct=" + extinct +
                '}';
    }
}
