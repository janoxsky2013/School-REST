package com.ale.service.impl;

import com.ale.model.Course;
import com.ale.repo.ICourseRepo;
import com.ale.repo.IGenericRepo;
import com.ale.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {
    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Course> findPage(Pageable pageable) {
       return repo.findAll(pageable);
    }
}
