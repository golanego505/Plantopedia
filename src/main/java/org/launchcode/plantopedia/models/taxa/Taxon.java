package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Taxon taxon = (Taxon) o;

        if (!Objects.equals(id, taxon.id)) return false;
        return Objects.equals(slug, taxon.slug);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        return result;
    }
}
