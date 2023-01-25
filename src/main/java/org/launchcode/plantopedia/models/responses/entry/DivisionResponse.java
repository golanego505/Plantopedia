package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.taxa.Division;

public class DivisionResponse extends Response {
    private Division data;

    public Division getData() {
        return data;
    }

    public void setData(Division data) {
        this.data = data;
    }
}
