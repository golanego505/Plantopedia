package org.launchcode.plantopedia.responses.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntryMeta {
    @JsonProperty("last_modified")
    private String lastModified;

    @JsonProperty("last_modified")
    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "EntryMeta{" +
                "lastModified='" + lastModified + '\'' +
                '}';
    }
}
