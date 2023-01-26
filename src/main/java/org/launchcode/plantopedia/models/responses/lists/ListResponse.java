package org.launchcode.plantopedia.models.responses.lists;

import org.launchcode.plantopedia.models.links.ListLinks;
import org.launchcode.plantopedia.models.metadata.ListMeta;

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
