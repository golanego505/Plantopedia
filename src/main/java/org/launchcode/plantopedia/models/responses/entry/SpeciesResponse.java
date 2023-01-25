package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.metadata.SpeciesEntryMeta;
import org.launchcode.plantopedia.models.taxa.Species;

public class SpeciesResponse {
    private Species data;
    private SpeciesEntryMeta meta;

    public Species getData() {
        return data;
    }

    public void setData(Species data) {
        this.data = data;
    }

    public SpeciesEntryMeta getMeta() {
        return meta;
    }

    public void setMeta(SpeciesEntryMeta meta) {
        this.meta = meta;
    }
}
