package org.launchcode.plantopedia.models.responses.retrievals;

import org.launchcode.plantopedia.models.taxa.Subkingdom;

public class SubkingdomRetrievalResponse extends RetrievalResponse {
    private Subkingdom data;

    public Subkingdom getData() {
        return data;
    }

    public void setData(Subkingdom data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "SubkingdomRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
