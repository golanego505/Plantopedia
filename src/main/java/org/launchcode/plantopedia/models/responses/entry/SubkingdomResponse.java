package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.taxa.Subkingdom;

public class SubkingdomResponse extends Response {
    private Subkingdom data;

    public Subkingdom getData() {
        return data;
    }

    public void setData(Subkingdom data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "SubkingdomResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
