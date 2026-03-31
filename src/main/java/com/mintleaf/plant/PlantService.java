package com.mintleaf.plant;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Iterable<Plant> getPlants(Long id, String name, String plantSpecies, String location, Long userId) {
        Specification<Plant> spec = Specification.unrestricted();
        if (id != null) {
            spec = spec.and(PlantSpec.hasId(id));
        }
        if (name != null) {
            spec = spec.and(PlantSpec.hasName(name));
        }
        if (plantSpecies != null) {
            spec = spec.and(PlantSpec.hasPlantSpecies(plantSpecies));
        }
        if (location != null) {
            spec = spec.and(PlantSpec.hasLocation(location));
        }
        if (userId != null) {
            spec = spec.and(PlantSpec.hasUserId(userId));
        }
        return this.plantRepository.findAll(spec);
    }

    public Plant addPlant(Plant plant) {
        return this.plantRepository.save(plant);
    }

    public Optional<Plant> updatePlant(Plant plant) {
        if (plant.getPlantId() == null) {
            return Optional.empty();
        }
        return this.plantRepository.findById(plant.getPlantId())
                .map(existing -> this.plantRepository.save(plant));
    }

    public void deletePlant(Long id) {
        Plant plant = this.plantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Plant with id [%d] does not exist", id)));
        this.plantRepository.delete(plant);
    }

}
