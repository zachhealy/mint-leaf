package com.mintleaf.plant;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Iterable<Plant> getPlants(Long id, String name, String plantSpecies, String location) {
        if (id != null) {
            return this.plantRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return this.plantRepository.findByName(name);
        }
        if (plantSpecies != null) {
            return this.plantRepository.findByPlantSpecies(plantSpecies);
        }
        if (location != null) {
            return this.plantRepository.findByLocation(location);
        }
        return this.plantRepository.findAll();

    }

    public Plant addPlant(Plant plant) {
        return this.plantRepository.save(plant);
    }

    public Optional<Plant> updatePlant(Plant plant) {
        if (plant.getId() == null) {
            return Optional.empty();
        }
        if (!this.plantRepository.existsById(plant.getId())) {
            return Optional.empty();
        }
        return Optional.of(this.plantRepository.save(plant));
    }

    public void deletePlant(Long id) {
        if (this.plantRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Plant with id " + id + " does not exist");
        }
        this.plantRepository.deleteById(id);
    }

}
