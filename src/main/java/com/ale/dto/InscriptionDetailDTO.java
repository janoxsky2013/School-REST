package com.ale.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InscriptionDetailDTO {
    @JsonBackReference
    private InscriptionDTO inscription;

    @JsonIncludeProperties(value = {"idCourse","acronymCourse","enableCourse","nameofCourse"})
    @NotNull
    private CourseDTO course;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 100)
    private String classroom;
}
