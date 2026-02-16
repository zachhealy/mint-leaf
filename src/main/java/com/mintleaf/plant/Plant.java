package com.mintleaf.plant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(name = "Name")
    @Getter
    @Setter
    private String name;

    @Column(name = "PlantSpecies")
    @Getter
    @Setter
    private String plantSpecies;

    @Column(name = "Location")
    @Getter
    @Setter
    private String location;

    @Column(name = "WateringFrequency")
    @Getter
    private int wateringFrequency;

    public void setWateringFrequency(int wateringFrequency) {
        if (wateringFrequency < 1 || wateringFrequency > 10) {
            throw new IllegalArgumentException("Watering frequency must be between 1 and 10");
        }
        this.wateringFrequency = wateringFrequency;
    }
}
