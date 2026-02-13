package com.mintleaf.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintleaf.repositories.PlantRepository;
import com.mintleaf.entity.Plant;

@RestController
public class MintController {

    private final PlantRepository plantRepository;

    public MintController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @GetMapping("/plants")
    public Iterable<Plant> getPlants() {
        return this.plantRepository.findAll();
    }

    @GetMapping("/plants/{id}")
    public Optional<Plant> getPlantById(@PathVariable("id") long id) {
        return this.plantRepository.findById(id);
    }

    @PostMapping("/addPlant")
    public Plant addPlant(Plant plant) {
        return this.plantRepository.save(plant);
    }

}
