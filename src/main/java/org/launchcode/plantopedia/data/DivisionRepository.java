package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends CrudRepository<Division, Integer> {
}
