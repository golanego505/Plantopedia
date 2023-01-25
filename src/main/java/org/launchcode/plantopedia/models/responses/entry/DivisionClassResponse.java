package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.taxa.DivisionClass;

public class DivisionClassResponse extends Response {
    private DivisionClass data;

    public DivisionClass getData() {
        return data;
    }

    public void setData(DivisionClass data) {
        this.data = data;
    }
}
