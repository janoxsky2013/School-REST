package com.ale.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(InscriptionDetailPK.class)
public class InscriptionDetail {
    @Id
    private Inscription inscription;

    @Id
    private Course course;

    @Column(nullable = false)
    private String classroom;
}
