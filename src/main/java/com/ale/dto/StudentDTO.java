package com.ale.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String cardId;

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 200)
    private String age;
}
