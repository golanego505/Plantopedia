package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Integer> {
}
