package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.launchcode.plantopedia.models.links.EntryLinks;
import org.launchcode.plantopedia.models.links.FamilyLinks;

public class Family extends Taxon {
    private String name;
    @JsonProperty("common_name")
    private String commonName;
    private FamilyLinks links;
    @JsonProperty("division_order")
    private DivisionOrder divisionOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("common_name")
    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public EntryLinks getLinks() {
        return links;
    }

    public void setLinks(FamilyLinks links) {
        this.links = links;
    }

    @JsonProperty("division_order")
    public DivisionOrder getDivisionOrder() {
        return divisionOrder;
    }

    public void setDivisionOrder(DivisionOrder divisionOrder) {
        this.divisionOrder = divisionOrder;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id='" + this.getId() +'\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", name='" + name + '\'' +
                ", commonName='" + commonName + '\'' +
                ", links=" + links +
                ", divisionOrder=" + divisionOrder +
                '}';
    }
}
