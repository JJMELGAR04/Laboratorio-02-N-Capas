package com.example.laboratorio02.service.impl;

import com.example.laboratorio02.domain.entity.Pirate;
import com.example.laboratorio02.repository.PirateRepository;
import com.example.laboratorio02.service.PirateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirateServiceImpl implements PirateService {

    private final PirateRepository pirateRepository;

    @Override
    public void createPirate(Pirate pirate) {
        pirateRepository.save(pirate);
    }

    @Override
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    @Override
    public Pirate getPirateById(UUID id) {
        return pirateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pirate not found with id: " + id));
    }

    @Override
    public void updatePirate(UUID id, Pirate pirate) {
        Pirate existing = getPirateById(id);
        existing.setName(pirate.getName());
        existing.setBounty(pirate.getBounty());
        existing.setCrew(pirate.getCrew());
        existing.setIsAlive(pirate.getIsAlive());
        pirateRepository.save(existing);
    }

    @Override
    public void deletePirate(UUID id) {
        pirateRepository.deleteById(id);
    }
}
