package com.openclassrooms.etudiant.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.openclassrooms.etudiant.entities.Student;
import com.openclassrooms.etudiant.entities.Visite;
import com.openclassrooms.etudiant.repository.VisiteRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class VisiteService {

	private final VisiteRepository visiteRepository;

	public String createVisite(Date in, Date out, Student student) {
		Visite visite = new Visite();
		visite.setIn(in);
		visite.setOut(out);
		visite.setStudent(student);
		visiteRepository.save(visite);
		return "200";
	}

}