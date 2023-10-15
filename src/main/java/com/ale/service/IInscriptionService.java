package com.ale.service;

import com.ale.model.Course;
import com.ale.model.Inscription;
import com.ale.model.InscriptionDetail;
import com.ale.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IInscriptionService extends ICRUD<Inscription, Integer>{
    Page<Inscription> findPage(Pageable pageable);

    Map<String, List<String>> getGroupBy(); //obtener una agrupacion de cursos y estudiantes
}
