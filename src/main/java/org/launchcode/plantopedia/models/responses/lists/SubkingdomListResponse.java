package org.launchcode.plantopedia.models.responses.lists;

import org.launchcode.plantopedia.models.taxa.Subkingdom;

import java.util.List;

public class SubkingdomListResponse extends ListResponse {
    private List<Subkingdom> data;

    public List<Subkingdom> getData() {
        return data;
    }

    public void setData(List<Subkingdom> data) {
        this.data = data;
    }
}
