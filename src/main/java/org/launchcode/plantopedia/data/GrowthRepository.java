package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Species;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowthRepository extends CrudRepository<Species.Growth, Integer> {
}
