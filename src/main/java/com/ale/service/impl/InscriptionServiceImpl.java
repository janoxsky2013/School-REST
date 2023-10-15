package com.ale.service.impl;

import com.ale.dto.InscriptionDetailDTO;
import com.ale.model.Course;
import com.ale.model.Inscription;
import com.ale.model.InscriptionDetail;
import com.ale.model.Student;
import com.ale.repo.ICourseRepo;
import com.ale.repo.IGenericRepo;
import com.ale.repo.IInscriptionRepo;
import com.ale.repo.IStudentRepo;
import com.ale.service.IInscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;


import java.util.*;
import java.util.stream.*;


@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl extends CRUDImpl<Inscription, Integer> implements IInscriptionService {
    private final IInscriptionRepo repoInscripcion;
    private final IStudentRepo repoStudent;
    private final ICourseRepo repoCourse;
    @Override
    protected IGenericRepo<Inscription, Integer> getRepo() {
        return repoInscripcion;
    }

    @Override
    public Page<Inscription> findPage(Pageable pageable) {
        return repoInscripcion.findAll(pageable);
    }

    @Override
    public Map<String, List<String>> getGroupBy() {
        return repoInscripcion.findAll().stream()
                .collect(Collectors.groupingBy(
                        inscription -> inscription.getDetails().get(0).getCourse().getName(),
                        Collectors.mapping(inscription -> inscription.getStudent().getFirstName()+" "+inscription.getStudent().getLastName(), Collectors.toList())
                ));

    }


}
