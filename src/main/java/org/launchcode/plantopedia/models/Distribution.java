package org.launchcode.plantopedia.models;

import java.util.ArrayList;

public class Distribution {
    private ArrayList<String> ntv;
    private ArrayList<String> introduced;

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
}
