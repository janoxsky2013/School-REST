package com.ale.service.impl;

import com.ale.exception.ModelNotFoundException;
import com.ale.repo.IGenericRepo;
import com.ale.service.ICRUD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Method;

public abstract class CRUDImpl <T, ID> implements ICRUD<T, ID> {
    protected abstract IGenericRepo<T, ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        Class<?> clazz = t.getClass();
        String className = t.getClass().getSimpleName();
        String methodName = "setId" + className;  //genera el setIdPatient, setIdExam, etc
        Method setIdMethod = clazz.getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND " + id));
        return getRepo().save(t);
    }

    @Override
    public java.util.List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }

    @Override
    public Page<T> getPage(Pageable pageable) throws Exception {
        return getRepo().findAll(pageable);
    }
}
