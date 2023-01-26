package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.taxa.DivisionOrder;

public class DivisionOrderResponse extends Response {
    private DivisionOrder data;

    public DivisionOrder getData() {
        return data;
    }

    public void setData(DivisionOrder data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "DivisionOrderResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
