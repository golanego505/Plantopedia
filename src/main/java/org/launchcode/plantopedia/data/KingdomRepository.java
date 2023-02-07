package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Kingdom;
import org.springframework.data.repository.CrudRepository;

public interface KingdomRepository extends CrudRepository<Kingdom, Integer> {
}
