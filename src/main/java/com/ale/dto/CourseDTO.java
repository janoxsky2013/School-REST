package com.ale.dto;

import com.fasterxml.jackson.annotation.*;
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
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nameofCourse;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String acronymCourse;

    @NotNull
    private Boolean enableCourse;
}
