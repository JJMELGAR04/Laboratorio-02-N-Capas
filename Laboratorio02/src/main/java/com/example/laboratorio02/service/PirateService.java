package com.example.laboratorio02.service;

import com.example.laboratorio02.domain.entity.Pirate;

import java.util.List;
import java.util.UUID;

public interface PirateService {
    void createPirate(Pirate pirate);
    List<Pirate> getAllPirates();
    Pirate getPirateById(UUID id);
    void updatePirate(UUID id, Pirate pirate);
    void deletePirate(UUID id);
}
