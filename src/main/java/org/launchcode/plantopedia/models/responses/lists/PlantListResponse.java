package org.launchcode.plantopedia.models.responses.lists;

import org.launchcode.plantopedia.models.taxa.Plant;

import java.util.List;

public class PlantListResponse extends ListResponse {
    private List<Plant> data;

    public List<Plant> getData() {
        return data;
    }

    public void setData(List<Plant> data) {
        this.data = data;
    }
}
