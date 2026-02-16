package com.mintleaf.plant;

import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Iterable<Plant> getPlants(Map<String, Object> params) {
        if (params.containsKey("id")) {
            return this.plantRepository.findById((Long) params.get("id"));
        }
        if (params.containsKey("name")) {
            return this.plantRepository.findByName((String) params.get("name"));
        }
        if (params.containsKey("plantSpecies")) {
            return this.plantRepository.findByPlantSpecies((String) params.get("plantSpecies"));
        }
        if (params.containsKey("location")) {
            return this.plantRepository.findByLocation((String) params.get("location"));
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
