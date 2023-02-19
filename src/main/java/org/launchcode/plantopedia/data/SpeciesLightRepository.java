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
    List<SpeciesLight> findByCommonNameLikeOrderByCommonName(String name);

    List<SpeciesLight> findByCommonNameLikeOrderByScientificName(String name);
    List<SpeciesLight> findByScientificNameLikeOrderByCommonName(String name);
    List<SpeciesLight> findByScientificNameLikeOrderByScientificName(String name);
    List<SpeciesLight> findByCommonNameLikeOrScientificNameLike(String common, String scientific);
    List<SpeciesLight> findByCommonNameLikeOrScientificNameLikeOrderByCommonName(String common, String scientific);
    List<SpeciesLight> findByCommonNameLikeOrScientificNameLikeOrderByScientificName(String common, String scientific);
}
