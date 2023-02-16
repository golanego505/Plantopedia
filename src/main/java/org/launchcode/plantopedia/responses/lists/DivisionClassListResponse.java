package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.taxa.DivisionClass;

import java.util.List;

public class DivisionClassListResponse extends ListResponse {
    private List<DivisionClass> data;

    public List<DivisionClass> getData() {
        return data;
    }

    public void setData(List<DivisionClass> data) {
        this.data = data;
    }
}
