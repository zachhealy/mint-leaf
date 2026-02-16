package com.mintleaf.plant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/plants")
    public Iterable<Plant> getPlants(@RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String plantSpecies,
            @RequestParam(required = false) String location) {
        return this.plantService.getPlants(id, name, plantSpecies, location);
    }

    @PostMapping("/plants")
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
        return ResponseEntity.ok(this.plantService.addPlant(plant));
    }

    @PutMapping("/plants")
    public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) {
        return ResponseEntity.ok(this.plantService.updatePlant(plant));
    }

    @DeleteMapping("/plants")
    public ResponseEntity<Void> deletePlant(@RequestParam Integer id) {
        this.plantService.deletePlant(id);
        return ResponseEntity.ok().build();
    }

}
