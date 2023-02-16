package org.launchcode.plantopedia.responses.lists;

import org.launchcode.plantopedia.responses.links.ListLinks;
import org.launchcode.plantopedia.responses.metadata.ListMeta;

public abstract class ListResponse {
    private ListLinks links;
    private ListMeta meta;

    public ListLinks getLinks() {
        return links;
    }

    public void setLinks(ListLinks links) {
        this.links = links;
    }

    public ListMeta getMeta() {
        return meta;
    }

    public void setMeta(ListMeta meta) {
        this.meta = meta;
    }
}
