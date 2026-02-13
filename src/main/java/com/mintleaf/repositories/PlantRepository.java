package com.mintleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mintleaf.entity.Plant;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    List<Plant> findByName(String name);

    List<Plant> findByLocation(String location);

}
