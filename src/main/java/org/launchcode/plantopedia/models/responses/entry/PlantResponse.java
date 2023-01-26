package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.taxa.Plant;

public class PlantResponse extends Response {
    private Plant data;

    public Plant getData() {
        return data;
    }

    public void setData(Plant data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "PlantResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
