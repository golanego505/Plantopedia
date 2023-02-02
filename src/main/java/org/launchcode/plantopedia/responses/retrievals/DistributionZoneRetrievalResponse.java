package org.launchcode.plantopedia.responses.retrievals;

import org.launchcode.plantopedia.models.distributions.Zone;

public class DistributionZoneRetrievalResponse extends RetrievalResponse {
    private Zone data;

    public Zone getData() {
        return data;
    }

    public void setData(Zone data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DistributionZoneRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
