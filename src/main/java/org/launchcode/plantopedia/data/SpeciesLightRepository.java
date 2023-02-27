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

//    @Query(value = "select * from plantopedia.species_light where species_light.species_rank like '%species%';")
//    List<SpeciesLight> findBySpeciesRankContainingIgnoreCase(String rank);
    List<SpeciesLight> findByYearLike(String year);
    List<SpeciesLight> findByCommonNameLikeIgnoreCase(String name);
    List<SpeciesLight> findByGenusLike(String genus);
    List<SpeciesLight> findByFamilyLike(String family);
    List<SpeciesLight> findByAuthorLike(String author);
    List<SpeciesLight> findByScientificNameLike(String name);
    List<SpeciesLight> findByBibliographyLike(String bibliography);
//    List<SpeciesLight> findByStatusLike(String status);
    List<SpeciesLight> findByFamilyCommonNameLike(String name);
    List<SpeciesLight> findByFamilyCommonNameContainingIgnoreCase(String name);
//    List<SpeciesLight> findByStatusContainingIgnoreCase(String status);
    List<SpeciesLight> findByBibliographyContainingIgnoreCase(String bibliography);
    List<SpeciesLight> findByAuthorContainingIgnoreCase(String author);
    List<SpeciesLight> findByFamilyContainingIgnoreCase(String family);
    List<SpeciesLight> findByGenusContainingIgnoreCase(String genus);
    List<SpeciesLight> findByYear(Integer year);
}
