package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.DistributionZone;

public class DistributionZoneResponse extends Response {
    private DistributionZone data;

    public DistributionZone getData() {
        return data;
    }

    public void setData(DistributionZone data) {
        this.data = data;
    }
}
