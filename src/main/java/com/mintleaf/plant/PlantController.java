package com.mintleaf.plant;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/plants")
    public Iterable<Plant> getPlants(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String plantSpecies,
            @RequestParam(required = false) String location) {
        return this.plantService.getPlants(id, name, plantSpecies, location);
    }

    @PostMapping("/plants")
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
        Plant savedPlant = this.plantService.addPlant(plant);
        if (savedPlant == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(savedPlant);
    }

    @PutMapping("/plants")
    public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) {
        Optional<Plant> updatedPlant = this.plantService.updatePlant(plant);
        if (updatedPlant == null || updatedPlant.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPlant.get());
    }

    @DeleteMapping("/plants")
    public ResponseEntity<Void> deletePlant(@RequestParam Long id) {
        try {
            this.plantService.deletePlant(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
