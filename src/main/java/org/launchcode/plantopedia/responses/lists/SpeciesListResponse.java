package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.taxa.SpeciesLight;

import java.util.List;

public class SpeciesListResponse extends ListResponse {
    private List<SpeciesLight> data;

    public List<SpeciesLight> getData() {
        return data;
    }

    public void setData(List<SpeciesLight> data) {
        this.data = data;
    }
}
