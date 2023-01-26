package org.launchcode.plantopedia.models.responses.retrievals;

import org.launchcode.plantopedia.models.metadata.EntryMeta;

public abstract class RetrievalResponse {
    private EntryMeta meta;

    public EntryMeta getMeta() {
        return meta;
    }

    public void setMeta(EntryMeta meta) {
        this.meta = meta;
    }
}
