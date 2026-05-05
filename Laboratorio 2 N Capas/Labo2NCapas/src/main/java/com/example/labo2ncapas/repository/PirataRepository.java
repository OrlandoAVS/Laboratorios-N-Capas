package com.example.labo2ncapas.repository;

import com.example.labo2ncapas.domain.entity.Pirata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PirataRepository extends JpaRepository<Pirata, UUID>{
}
