package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Family extends PlantFamily {
    @ManyToOne
    @JsonProperty("division_order")
    private DivisionOrder divisionOrder;

    public Family() {
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
