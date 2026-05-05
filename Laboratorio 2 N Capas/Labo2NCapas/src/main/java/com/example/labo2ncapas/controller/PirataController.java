package com.example.labo2ncapas.controller;

import com.example.labo2ncapas.domain.entity.Pirata;
import com.example.labo2ncapas.service.PirataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pirata")
@RequiredArgsConstructor
public class PirataController {

    private final PirataService pirataService;

    @PostMapping
    public ResponseEntity<Pirata> createPirata(@RequestBody Pirata pirata) {
        Pirata created = pirataService.createPirata(pirata);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Pirata>> getAllPiratas() {
        return ResponseEntity.ok(pirataService.getAllPiratas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pirata> getPirataById(@PathVariable UUID id) {
        return ResponseEntity.ok(pirataService.getPirataById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pirata> updatePirata(
            @PathVariable UUID id,
            @RequestBody Pirata pirata) {
        return ResponseEntity.ok(pirataService.updatePirata(id, pirata));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePirata(@PathVariable UUID id) {
        pirataService.deletePirata(id);
        return ResponseEntity.noContent().build();
    }
}