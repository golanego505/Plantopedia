package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.taxa.Family;

public class FamilyResponse extends Response {
    private Family data;

    public Family getData() {
        return data;
    }

    public void setData(Family data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "FamilyResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
