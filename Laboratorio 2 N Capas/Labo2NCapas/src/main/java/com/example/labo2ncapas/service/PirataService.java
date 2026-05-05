package com.example.labo2ncapas.service;


import com.example.labo2ncapas.domain.entity.Pirata;

import java.util.List;
import java.util.UUID;

public interface PirataService {

    Pirata createPirata(Pirata pirata);

    List<Pirata> getAllPiratas();

    Pirata getPirataById(UUID id);

    Pirata updatePirata(UUID id, Pirata pirata);

    void deletePirata(UUID id);
}