package org.launchcode.plantopedia.models.responses.retrievals;

import org.launchcode.plantopedia.models.taxa.Family;

public class FamilyRetrievalResponse extends RetrievalResponse {
    private Family data;

    public Family getData() {
        return data;
    }

    public void setData(Family data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "FamilyRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
