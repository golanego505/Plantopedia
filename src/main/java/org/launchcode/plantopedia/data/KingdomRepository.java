package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Kingdom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KingdomRepository extends CrudRepository<Kingdom, Integer> {
}
