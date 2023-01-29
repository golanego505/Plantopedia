package org.launchcode.plantopedia.responses.retrievals;

import org.launchcode.plantopedia.models.distributions.DistributionZone;

public class DistributionZoneRetrievalResponse extends RetrievalResponse {
    private DistributionZone data;

    public DistributionZone getData() {
        return data;
    }

    public void setData(DistributionZone data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DistributionZoneRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
