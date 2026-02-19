package com.mintleaf.plant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long>, JpaSpecificationExecutor<Plant> {
    Optional<Plant> findById(Long id);

    Iterable<Plant> findByName(String name);

    Iterable<Plant> findByPlantSpecies(String plantSpecies);

    Iterable<Plant> findByLocation(String location);

    boolean existsById(Long id);

    void deleteById(Long id);

}
