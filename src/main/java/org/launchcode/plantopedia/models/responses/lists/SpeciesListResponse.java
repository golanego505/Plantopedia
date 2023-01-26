package org.launchcode.plantopedia.models.responses.lists;

import org.launchcode.plantopedia.models.taxa.PlantSpecies;

import java.util.List;

public class SpeciesListResponse extends ListResponse {
    private List<PlantSpecies> data;

    public List<PlantSpecies> getData() {
        return data;
    }

    public void setData(List<PlantSpecies> data) {
        this.data = data;
    }
}
