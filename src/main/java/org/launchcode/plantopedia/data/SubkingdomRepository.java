package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Subkingdom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubkingdomRepository extends CrudRepository<Subkingdom, Integer> {
}
