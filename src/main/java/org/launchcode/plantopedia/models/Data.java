package org.launchcode.plantopedia.models;

import org.launchcode.plantopedia.models.links.EntryLinks;

public class Data {
    private Integer id;
    private String name;
    private String slug;
    private EntryLinks entryLinks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public EntryLinks getLinks() {
        return entryLinks;
    }

    public void setLinks(EntryLinks entryLinks) {
        this.entryLinks = entryLinks;
    }
}
