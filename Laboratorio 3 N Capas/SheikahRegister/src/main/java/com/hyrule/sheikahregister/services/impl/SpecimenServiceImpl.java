package com.hyrule.sheikahregister.services.impl;

import com.hyrule.sheikahregister.dto.*;
import com.hyrule.sheikahregister.domain.entities.Specimen;
import com.hyrule.sheikahregister.exceptions.ResourceNotFoundException;
import com.hyrule.sheikahregister.mappers.SpecimenMapper;
import com.hyrule.sheikahregister.repositories.SpecimenRepository;
import com.hyrule.sheikahregister.services.SpecimenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecimenServiceImpl implements SpecimenService {

    private final SpecimenRepository specimenRepository;
    private final SpecimenMapper specimenMapper;

    @Override
    @Transactional
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request) {
        Specimen saved = specimenRepository.save(specimenMapper.toEntityCreate(request));
        return specimenMapper.toDto(saved);
    }

    // RETO 1: Paginación dinámica con PageRequest y Sort
    @Override
    public PageableResponse<SpecimenResponse> getAllSpecimens(
            int page, int size, String sortBy, String sortOrder) {

        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Specimen> specimenPage = specimenRepository.findAll(pageable);

        if (specimenPage.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No specimens are registered in the Sheikah Slate records");
        }

        return specimenMapper.toPageableResponse(specimenPage, sortBy, sortOrder);
    }

    // RETO 3: Excepción personalizada en lugar de RuntimeException genérico
    @Override
    public SpecimenResponse getSpecimenById(UUID id) {
        Specimen specimen = specimenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Specimen not found in Sheikah Slate records with ID: " + id));
        return specimenMapper.toDto(specimen);
    }

    @Override
    @Transactional
    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request) {
        this.getSpecimenById(id); // valida existencia, lanza 404 si no existe
        Specimen updated = specimenRepository.save(specimenMapper.toEntityUpdate(request, id));
        return specimenMapper.toDto(updated);
    }

    @Override
    @Transactional
    public SpecimenResponse deleteSpecimen(UUID id) {
        SpecimenResponse existing = this.getSpecimenById(id); // lanza 404 si no existe
        specimenRepository.deleteById(id);
        return existing;
    }
}
