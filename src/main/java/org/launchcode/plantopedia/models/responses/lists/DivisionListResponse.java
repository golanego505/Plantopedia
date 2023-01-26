package org.launchcode.plantopedia.models.responses.lists;

import org.launchcode.plantopedia.models.taxa.Division;

import java.util.List;

public class DivisionListResponse extends ListResponse {
    private List<Division> data;

    public List<Division> getData() {
        return data;
    }

    public void setData(List<Division> data) {
        this.data = data;
    }
}
