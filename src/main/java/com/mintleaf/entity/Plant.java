package com.mintleaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "Name")
    public String name;

    @Column(name = "PlantSpecies")
    public String plantSpecies;

    @Column(name = "Location")
    public String location;

    @Column(name = "WateringFrequency")
    public int wateringFrequency;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlantSpecies() {
        return this.plantSpecies;
    }

    public void setPlantSpecies(String plantSpecies) {
        this.plantSpecies = plantSpecies;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWateringFrequency() {
        return this.wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) {
        if (wateringFrequency < 1 || wateringFrequency > 10) {
            throw new IllegalArgumentException("Watering frequency must be between 1 and 10");
        }
        this.wateringFrequency = wateringFrequency;
    }
}
