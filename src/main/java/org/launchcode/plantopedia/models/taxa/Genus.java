package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class Genus extends PlantGenus {
    @ManyToOne
    private Family family;
    public Genus() {}

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
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
