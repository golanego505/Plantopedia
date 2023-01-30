package org.launchcode.plantopedia.responses.retrievals;

import org.launchcode.plantopedia.models.taxa.Division;

public class DivisionRetrievalResponse extends RetrievalResponse {
    private Division data;

    public Division getData() {
        return data;
    }

    public void setData(Division data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DivisionRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
