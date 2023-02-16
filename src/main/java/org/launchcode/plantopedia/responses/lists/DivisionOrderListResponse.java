package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.taxa.DivisionOrder;

import java.util.List;

public class DivisionOrderListResponse extends ListResponse {
    private List<DivisionOrder> data;

    public List<DivisionOrder> getData() {
        return data;
    }

    public void setData(List<DivisionOrder> data) {
        this.data = data;
    }
}
