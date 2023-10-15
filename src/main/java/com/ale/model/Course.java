package com.ale.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String acronym;

    @Column(nullable = false)
    private Boolean enabled;

    public Course(String name, String acronym, boolean enabled){
        this.name=name;
        this.acronym=acronym;
        this.enabled=enabled;

    }
}
