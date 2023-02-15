package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.distributions.TdwgUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TdwgUnitRepository extends CrudRepository<TdwgUnit, Integer> {
}
