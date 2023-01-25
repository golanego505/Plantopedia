package org.launchcode.plantopedia.models.responses.entry;

import org.launchcode.plantopedia.models.metadata.EntryMeta;

public abstract class Response {
    private EntryMeta meta;

    public EntryMeta getMeta() {
        return meta;
    }

    public void setMeta(EntryMeta meta) {
        this.meta = meta;
    }
}
