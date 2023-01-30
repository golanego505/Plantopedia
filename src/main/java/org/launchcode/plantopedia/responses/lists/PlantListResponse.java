package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.taxa.PlantOrSpeciesListEntry;

import java.util.List;

public class PlantListResponse extends ListResponse {
    private List<PlantOrSpeciesListEntry> data;

    public List<PlantOrSpeciesListEntry> getData() {
        return data;
    }

    public void setData(List<PlantOrSpeciesListEntry> data) {
        this.data = data;
    }
}
