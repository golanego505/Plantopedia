package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import org.launchcode.plantopedia.responses.links.GenusLinks;

@MappedSuperclass
public class PlantGenus extends Taxon {
    private String name;
    @Transient
    private GenusLinks links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenusLinks getLinks() {
        return links;
    }

    public void setLinks(GenusLinks links) {
        this.links = links;
    }
}
