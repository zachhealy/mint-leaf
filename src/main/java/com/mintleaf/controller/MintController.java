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
    public Optional<Plant> getPlantById(@PathVariable("id") Integer id) {
        return this.plantRepository.findById(id);
    }

    @GetMapping("/plants/name/{name}")
    public Iterable<Plant> getPlantsByName(@PathVariable("name") String name) {
        return this.plantRepository.findByName(name);
    }

    @GetMapping("/plants/location/{location}")
    public Iterable<Plant> getPlantsByLocation(@PathVariable("location") String location) {
        return this.plantRepository.findByLocation(location);
    }

    @PostMapping("/addPlant")
    public Plant addPlant(Plant plant) {
        return this.plantRepository.save(plant);
    }

}
