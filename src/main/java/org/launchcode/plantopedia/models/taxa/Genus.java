package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.launchcode.plantopedia.responses.links.GenusLinks;

import java.util.List;

@Entity
@Access(AccessType.FIELD)
public class Genus extends Taxon {
    private String name;
    @Transient
    private GenusLinks links;
    @ManyToOne
    private Family family;
    @JsonIgnore
    @OneToMany(mappedBy = "genusForORM", fetch = FetchType.LAZY)
    private List<SpeciesLight> speciesLightList;

    public Genus() {}
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


    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<SpeciesLight> getSpeciesLightList() {
        return speciesLightList;
    }

    public void setSpeciesLightList(List<SpeciesLight> speciesLightList) {
        this.speciesLightList = speciesLightList;
    }

    @Override
    public String toString() {
        return "Genus{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", links=" + this.getLinks() +
                ", family=" + family +
                '}';
    }
}
