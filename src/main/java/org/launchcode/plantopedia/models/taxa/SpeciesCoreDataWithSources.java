package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public abstract class SpeciesCoreDataWithSources extends SpeciesCoreData {
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "species_source", inverseJoinColumns = {
            @JoinColumn(name = "source_id")
    })
    private List<TaxonWithSources.Source> sources;

    public List<TaxonWithSources.Source> getSources() {
        return sources;
    }

    public void setSources(List<TaxonWithSources.Source> sources) {
        this.sources = sources;
    }
}
