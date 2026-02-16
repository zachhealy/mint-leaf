package com.mintleaf.plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Iterable<Plant> findById(Long id);

    Iterable<Plant> findByName(String name);

    Iterable<Plant> findByPlantSpecies(String plantSpecies);

    Iterable<Plant> findByLocation(String location);

    boolean existsById(Long id);

}
