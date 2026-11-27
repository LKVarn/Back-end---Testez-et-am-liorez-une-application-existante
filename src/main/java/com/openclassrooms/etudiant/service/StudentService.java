package com.openclassrooms.etudiant.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.openclassrooms.etudiant.entities.Student;
import com.openclassrooms.etudiant.repository.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;

	public String createStudent(Student student) {
		if (student.getFirstVisit() == null) {
			student.setFirstVisit(new Date());
		}
		studentRepository.save(student);
		return "200";
	}

}