package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.TaxonWithSources;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends CrudRepository<TaxonWithSources.Source, String> {
}
