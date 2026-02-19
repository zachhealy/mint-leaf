package com.mintleaf.plant;

import com.mintleaf.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "plants")
public class Plant {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_userId", nullable = false)
    private User owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;

    private String name;

    private String plantSpecies;

    private String location;

    @Getter
    private int wateringFrequency;

    public void setWateringFrequency(int wateringFrequency) {
        if (wateringFrequency < 1 || wateringFrequency > 10) {
            throw new IllegalArgumentException("Watering frequency must be between 1 and 10");
        }
        this.wateringFrequency = wateringFrequency;
    }
}
