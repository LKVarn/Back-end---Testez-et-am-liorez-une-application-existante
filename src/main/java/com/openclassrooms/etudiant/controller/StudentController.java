package com.openclassrooms.etudiant.controller;

import com.openclassrooms.etudiant.dto.LoginRequestDTO;
import com.openclassrooms.etudiant.dto.RegisterDTO;
import com.openclassrooms.etudiant.dto.StudentDTO;
import com.openclassrooms.etudiant.mapper.StudentDtoMapper;
import com.openclassrooms.etudiant.mapper.UserDtoMapper;
import com.openclassrooms.etudiant.service.StudentService;
import com.openclassrooms.etudiant.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentDtoMapper studentDtoMapper;

    @PostMapping("/api/createStudent")
    public ResponseEntity<?> register(@Valid @RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDtoMapper.toEntity(studentDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/students")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PutMapping("/api/modifyStudents/{id}/firstname")
    public ResponseEntity<Void> updateStudentFirstName(@PathVariable Long id, @RequestBody StudentDTO request) {
        studentService.updateFirstName(id, request.firstName());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/modifyStudents/{id}/lastname")
    public ResponseEntity<Void> updateStudentLastName(@PathVariable Long id, @RequestBody StudentDTO request) {
        studentService.updateLastName(id, request.lastName());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/modifyStudents/{id}/section")
    public ResponseEntity<Void> updateStudentSection(@PathVariable Long id, @RequestBody StudentDTO request) {
        studentService.updateSection(id, request.section());
        return ResponseEntity.noContent().build();
    }
}
