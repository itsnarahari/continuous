package com.test.boot.service;


import com.test.boot.dao.PlanetRepository;
import com.test.boot.models.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    public Planet savePlanet(Planet planet) {
        return planetRepository.save(planet);
    }
}
