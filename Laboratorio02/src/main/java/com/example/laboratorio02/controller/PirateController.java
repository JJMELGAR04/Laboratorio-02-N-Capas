package com.example.laboratorio02.controller;

import com.example.laboratorio02.domain.entity.Pirate;
import com.example.laboratorio02.service.impl.PirateServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pirates")
@AllArgsConstructor
public class PirateController {

    private final PirateServiceImpl pirateService;

    @PostMapping
    public ResponseEntity<Pirate> createPirate(@RequestBody Pirate pirate) {
        pirateService.createPirate(pirate);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pirate);
    }

    @GetMapping
    public ResponseEntity<List<Pirate>> getAllPirates() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pirateService.getAllPirates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pirate> getPirateById(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pirateService.getPirateById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePirate(@PathVariable UUID id, @RequestBody Pirate pirate) {
        pirateService.updatePirate(id, pirate);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePirate(@PathVariable UUID id) {
        pirateService.deletePirate(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
