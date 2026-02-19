package com.mintleaf.plant;

import org.springframework.data.jpa.domain.Specification;

public class PlantSpec {
    public static Specification<Plant> hasId(Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Plant> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Plant> hasPlantSpecies(String plantSpecies) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("plantSpecies"), plantSpecies);
    }

    public static Specification<Plant> hasLocation(String location) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("location"), location);
    }

    public static Specification<Plant> hasUserId(Long userId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isMember(userId, root.get("ownedPlants"));
    }

}
