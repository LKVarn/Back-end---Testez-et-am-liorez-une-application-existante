package com.openclassrooms.etudiant.repository;

import com.openclassrooms.etudiant.entities.Visite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisiteRepository extends JpaRepository<Visite, Long> {
}
