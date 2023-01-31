package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.taxa.Genus;

import java.util.List;

public class GenusListResponse extends ListResponse {
    private List<Genus> data;

    public List<Genus> getData() {
        return data;
    }

    public void setData(List<Genus> data) {
        this.data = data;
    }
}
