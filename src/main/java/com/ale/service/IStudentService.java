package com.ale.service;

import com.ale.model.Course;
import com.ale.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer>{
    Page<Student> findPage(Pageable pageable);
    List<Student> findAllOrder(String param);
}
