package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.distributions.Zone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends CrudRepository<Zone, Integer> {
}
