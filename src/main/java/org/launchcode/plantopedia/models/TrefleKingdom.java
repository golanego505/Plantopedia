package org.launchcode.plantopedia.models;

import org.launchcode.plantopedia.models.metadata.EntryMeta;

public class TrefleKingdom {
    private Data data;
    private EntryMeta meta;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public EntryMeta getMeta() {
        return meta;
    }

    public void setMeta(EntryMeta meta) {
        this.meta = meta;
    }
}
