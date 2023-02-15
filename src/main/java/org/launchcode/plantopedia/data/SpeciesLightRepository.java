package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.SpeciesLight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesLightRepository extends CrudRepository<SpeciesLight, Integer> {
}
