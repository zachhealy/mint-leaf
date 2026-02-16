package com.mintleaf.plant;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Iterable<Plant> getPlants(String name, String plantSpecies, String location) {
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

    public @Nullable Plant updatePlant(Plant plant) {
        if (plant.getId() == null) {
            return null;
        }
        if (!this.plantRepository.existsById(plant.getId())) {
            return null;
        }
        return this.plantRepository.save(plant);
    }

    public void deletePlant(Integer id) {
        this.plantRepository.deleteById(id);
    }

}
