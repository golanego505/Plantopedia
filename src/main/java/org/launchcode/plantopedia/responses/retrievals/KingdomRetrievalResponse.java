package org.launchcode.plantopedia.responses.retrievals;

import org.launchcode.plantopedia.models.taxa.Kingdom;

public class KingdomRetrievalResponse extends RetrievalResponse {
    private Kingdom data;

    public Kingdom getData() {
        return data;
    }

    public void setData(Kingdom data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "KingdomRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
