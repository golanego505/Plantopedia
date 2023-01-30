package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.distributions.DistributionZone;

import java.util.List;

public class DistributionZoneListResponse extends ListResponse {
    private List<DistributionZone> data;

    public List<DistributionZone> getData() {
        return data;
    }

    public void setData(List<DistributionZone> data) {
        this.data = data;
    }
}
