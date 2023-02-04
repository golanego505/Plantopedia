package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.distributions.Zone;

import java.util.List;

public class ZoneListResponse extends ListResponse {
    private List<Zone> data;

    public List<Zone> getData() {
        return data;
    }

    public void setData(List<Zone> data) {
        this.data = data;
    }
}
