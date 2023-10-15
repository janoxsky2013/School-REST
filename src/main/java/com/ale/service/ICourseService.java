package com.ale.service;

import com.ale.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICourseService extends ICRUD<Course, Integer> {
    Page<Course> findPage(Pageable pageable);
}
