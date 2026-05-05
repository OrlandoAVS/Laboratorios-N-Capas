package com.example.labo2ncapas.service.impl;

import com.example.labo2ncapas.domain.entity.Pirata;
import com.example.labo2ncapas.repository.PirataRepository;
import com.example.labo2ncapas.service.PirataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirataServiceImpl implements PirataService {

    private final PirataRepository pirataRepository;
    @Override
    public Pirata createPirata(Pirata pirata) {
        return pirataRepository.save(pirata);
    }

    @Override
    public List<Pirata> getAllPiratas() {
        return pirataRepository.findAll();
    }

    @Override
    public Pirata getPirataById(UUID id) {
        return pirataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Pirata no encontrado con id: " + id));
    }

    @Override
    public Pirata updatePirata(UUID id, Pirata updated) {
        Pirata existing = getPirataById(id);
        existing.setName(updated.getName());
        existing.setBounty(updated.getBounty());
        existing.setCrew(updated.getCrew());
        existing.setAlive(updated.isAlive());
        return pirataRepository.save(existing);
    }

    @Override
    public void deletePirata(UUID id) {
        Pirata existing = getPirataById(id);
        pirataRepository.delete(existing);
    }
}