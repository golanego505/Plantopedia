package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.taxa.Kingdom;

public class KingdomResponse extends Response {
    private Kingdom data;

    public Kingdom getData() {
        return data;
    }

    public void setData(Kingdom data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "KingdomResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
