package org.launchcode.plantopedia.models;

import java.util.ArrayList;

public class Distributions {
    private ArrayList<TdwgUnit> ntv;
    private ArrayList<TdwgUnit> introduced;

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
}
