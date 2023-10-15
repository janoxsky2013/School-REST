package com.ale.config;

import com.ale.dto.CourseDTO;
import com.ale.model.Course;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("courseMapper")
    public ModelMapper courseMapper(){
        ModelMapper mapper = new ModelMapper();

        //Lectura
        TypeMap<Course, CourseDTO> typeMap1 = mapper.createTypeMap(Course.class, CourseDTO.class);
        typeMap1.addMapping(Course::getName, (dest, v) -> dest.setNameofCourse((String) v));
        typeMap1.addMapping(Course::getEnabled, (dest, v) -> dest.setEnableCourse((Boolean) v));

        //Escritura
        TypeMap<CourseDTO, Course> typeMap2 = mapper.createTypeMap(CourseDTO.class, Course.class);
        typeMap2.addMapping(CourseDTO::getNameofCourse, (dest, v)-> dest.setName((String) v));
        typeMap2.addMapping(CourseDTO::getEnableCourse, (dest, v)-> dest.setEnabled((Boolean) v));
        return mapper;
    }

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }
}
