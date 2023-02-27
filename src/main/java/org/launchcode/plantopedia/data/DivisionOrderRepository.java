package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.DivisionOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionOrderRepository extends CrudRepository<DivisionOrder, Integer> {
}
