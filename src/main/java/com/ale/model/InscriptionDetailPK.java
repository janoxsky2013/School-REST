package com.ale.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class InscriptionDetailPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_inscription", nullable = false)
    private Inscription inscription;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false)
    private Course course;
}
