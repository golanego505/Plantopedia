package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.taxa.Genus;

public class GenusResponse extends Response {
    private Genus data;

    public Genus getData() {
        return data;
    }

    public void setData(Genus data) {
        this.data = data;
    }
}
