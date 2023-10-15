package com.ale.service.impl;

import com.ale.model.Course;
import com.ale.model.Student;
import com.ale.repo.IGenericRepo;
import com.ale.repo.IStudentRepo;
import com.ale.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {
    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Student> findPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Student> findAllOrder(String param) {
        Sort.Direction direction = param.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return repo.findAll(Sort.by(direction, "age"));
    }
}
