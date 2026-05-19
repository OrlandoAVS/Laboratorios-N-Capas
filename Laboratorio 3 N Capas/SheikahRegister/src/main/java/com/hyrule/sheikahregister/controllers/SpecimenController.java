package com.hyrule.sheikahregister.controllers;

import com.hyrule.sheikahregister.dto.*;
import com.hyrule.sheikahregister.services.SpecimenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("api/specimen")
@RequiredArgsConstructor
public class SpecimenController {

    private final SpecimenService specimenService;

    private <T> ResponseEntity<GeneralResponse<T>> buildResponse(
            T data, String message, HttpStatus status, HttpServletRequest request) {

        GeneralResponse<T> response = GeneralResponse.<T>builder()
                .message(message)
                .status(status.value())
                .uri(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .data(data)
                .build();

        return ResponseEntity.status(status).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> createSpecimen(
            @Valid @RequestBody CreateSpecimenRequest request,
            HttpServletRequest httpRequest) {

        SpecimenResponse created = specimenService.createSpecimen(request);
        return buildResponse(
                created,
                "Specimen successfully registered in the Sheikah Slate",
                HttpStatus.CREATED,
                httpRequest);
    }

    @GetMapping("/getAll")
    public ResponseEntity<GeneralResponse<PageableResponse<SpecimenResponse>>> getAllSpecimens(
            @RequestParam(defaultValue = "0")   int page,
            @RequestParam(defaultValue = "10")  int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            HttpServletRequest httpRequest) {

        PageableResponse<SpecimenResponse> result =
                specimenService.getAllSpecimens(page, size, sortBy, sortOrder);

        return buildResponse(
                result,
                "Sheikah Slate records retrieved successfully",
                HttpStatus.OK,
                httpRequest);
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> getSpecimenById(
            @PathVariable UUID id,
            HttpServletRequest httpRequest) {

        SpecimenResponse specimen = specimenService.getSpecimenById(id);
        return buildResponse(
                specimen,
                "Specimen found in the Sheikah Slate",
                HttpStatus.OK,
                httpRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> updateSpecimen(
            @PathVariable UUID id,
            @RequestBody UpdateSpecimenRequest request,
            HttpServletRequest httpRequest) {

        SpecimenResponse updated = specimenService.updateSpecimen(id, request);
        return buildResponse(
                updated,
                "Specimen record updated in the Sheikah Slate",
                HttpStatus.OK,
                httpRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> deleteSpecimen(
            @PathVariable UUID id,
            HttpServletRequest httpRequest) {

        SpecimenResponse deleted = specimenService.deleteSpecimen(id);
        return buildResponse(
                deleted,
                "Specimen successfully removed from the Sheikah Slate",
                HttpStatus.OK,
                httpRequest);
    }
}
