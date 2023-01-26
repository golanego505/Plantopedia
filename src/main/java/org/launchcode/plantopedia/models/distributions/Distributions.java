package org.launchcode.plantopedia.models.distributions;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.launchcode.plantopedia.models.distributions.TdwgUnit;

import java.util.ArrayList;

public class Distributions {
    @JsonProperty("native")
    private ArrayList<TdwgUnit> ntv;
    private ArrayList<TdwgUnit> introduced;

    @JsonProperty("native")
    public ArrayList<TdwgUnit> getNtv() {
        return ntv;
    }

    public void setNtv(ArrayList<TdwgUnit> ntv) {
        this.ntv = ntv;
    }

    public ArrayList<TdwgUnit> getIntroduced() {
        return introduced;
    }

    public void setIntroduced(ArrayList<TdwgUnit> introduced) {
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
