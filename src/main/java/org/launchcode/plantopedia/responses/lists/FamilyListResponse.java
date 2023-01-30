package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.models.taxa.Family;

import java.util.List;

public class FamilyListResponse extends ListResponse {
    private List<Family> data;

    public List<Family> getData() {
        return data;
    }

    public void setData(List<Family> data) {
        this.data = data;
    }
}
