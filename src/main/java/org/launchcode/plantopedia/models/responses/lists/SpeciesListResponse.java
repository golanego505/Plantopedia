package org.launchcode.plantopedia.models.responses.lists;

import org.launchcode.plantopedia.models.taxa.Species;

import java.util.List;

public class SpeciesListResponse extends ListResponse {
    private List<Species> data;

    public List<Species> getData() {
        return data;
    }

    public void setData(List<Species> data) {
        this.data = data;
    }
}
