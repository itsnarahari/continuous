package com.test.boot.dao;

import com.test.boot.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {
}
