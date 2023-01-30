package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.taxa.Kingdom;

import java.util.List;

public class KingdomListResponse extends ListResponse {
    private List<Kingdom> data;

    public List<Kingdom> getData() {
        return data;
    }

    public void setData(List<Kingdom> data) {
        this.data = data;
    }
}
