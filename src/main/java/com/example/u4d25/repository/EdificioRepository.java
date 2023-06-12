package com.example.u4d25.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.u4d25.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, UUID> {

}
