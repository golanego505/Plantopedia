package org.launchcode.plantopedia.responses.retrievals;

import org.launchcode.plantopedia.models.taxa.DivisionClass;

public class DivisionClassRetrievalResponse extends RetrievalResponse {
    private DivisionClass data;

    public DivisionClass getData() {
        return data;
    }

    public void setData(DivisionClass data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DivisionClasssResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
