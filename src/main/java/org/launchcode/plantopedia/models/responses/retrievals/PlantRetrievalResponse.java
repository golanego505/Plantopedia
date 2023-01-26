package org.launchcode.plantopedia.models.responses.retrievals;

import org.launchcode.plantopedia.models.taxa.Plant;

public class PlantRetrievalResponse extends RetrievalResponse {
    private Plant data;

    public Plant getData() {
        return data;
    }

    public void setData(Plant data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "PlantRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
