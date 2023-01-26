package org.launchcode.plantopedia.models.responses.retrievals;

import org.launchcode.plantopedia.models.metadata.SpeciesEntryMeta;
import org.launchcode.plantopedia.models.taxa.Species;

public class SpeciesRetrievalResponse {
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
    @Override
    public String toString() {
        return "SpeciesRetrievalResponse{" +
                "data=" + data + '\'' +
                ", meta='" + this.getMeta() + '\'';
    }
}
