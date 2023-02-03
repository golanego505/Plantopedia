package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import org.launchcode.plantopedia.responses.links.FamilyLinks;

@Entity
public class Family extends Taxon {
    private String name;
    @JsonProperty("common_name")
    private String commonName;
    @Transient
    private FamilyLinks links;
    @ManyToOne
    @JsonProperty("division_order")
    private DivisionOrder divisionOrder;

    public Family() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public FamilyLinks getLinks() {
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
                ", name='" + this.getName() + '\'' +
                ", commonName='" + this.getCommonName() + '\'' +
                ", links=" + this.getLinks() +
                ", divisionOrder=" + divisionOrder +
                '}';
    }
}
