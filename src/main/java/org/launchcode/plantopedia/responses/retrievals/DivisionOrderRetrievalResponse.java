package org.launchcode.plantopedia.responses.retrievals;

import org.launchcode.plantopedia.models.taxa.DivisionOrder;

public class DivisionOrderRetrievalResponse extends RetrievalResponse {
    private DivisionOrder data;

    public DivisionOrder getData() {
        return data;
    }

    public void setData(DivisionOrder data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "DivisionOrderRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
