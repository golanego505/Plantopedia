package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.DivisionClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionClassRepository extends CrudRepository<DivisionClass, Integer> {
}
