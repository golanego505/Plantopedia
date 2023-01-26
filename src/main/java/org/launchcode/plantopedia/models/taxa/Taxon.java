package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Taxon {
    @Id
    private Integer id;
    private String slug;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Taxon{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                '}';
    }
}
