package org.launchcode.plantopedia.responses.retrievals;

import org.launchcode.plantopedia.models.taxa.Genus;

public class GenusRetrievalResponse extends RetrievalResponse {
    private Genus data;

    public Genus getData() {
        return data;
    }

    public void setData(Genus data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "GenusRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
