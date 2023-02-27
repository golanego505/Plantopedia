package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Integer> {
}
