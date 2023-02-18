package org.launchcode.plantopedia.data;

import org.launchcode.plantopedia.models.taxa.SpeciesLight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesLightRepository extends PagingAndSortingRepository<SpeciesLight, Integer>,
        CrudRepository<SpeciesLight, Integer> {
    List<SpeciesLight> findByCommonName(String commonName);
    List<SpeciesLight> findByCommonNameContainingIgnoreCase(String name);

    List<SpeciesLight> findByScientificNameContainingIgnoreCase(String name);
}
