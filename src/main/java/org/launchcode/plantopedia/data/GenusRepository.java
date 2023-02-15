package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.Genus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenusRepository extends CrudRepository<Genus, Integer> {
}
