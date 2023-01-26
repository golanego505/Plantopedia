package org.launchcode.plantopedia.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Distribution {
    @JsonProperty("native")
    private ArrayList<String> ntv;
    private ArrayList<String> introduced;

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
