package com.openclassrooms.etudiant.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentDTO(
	
    @NotBlank
     String firstName,
    @NotBlank
     String lastName,
    @NotBlank
     String section
    
) {}