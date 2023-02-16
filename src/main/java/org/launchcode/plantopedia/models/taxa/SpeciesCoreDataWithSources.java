package org.launchcode.plantopedia.models.taxa;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;

import java.util.List;

@MappedSuperclass
public abstract class SpeciesCoreDataWithSources extends SpeciesCoreData {
    @ManyToMany
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
