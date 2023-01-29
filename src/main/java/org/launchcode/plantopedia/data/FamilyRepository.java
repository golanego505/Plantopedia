package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Family;
import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends CrudRepository<Family, Integer> {
}
