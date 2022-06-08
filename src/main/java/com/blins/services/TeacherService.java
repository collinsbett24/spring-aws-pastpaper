package com.blins.services;

import com.blins.models.Teacher;
import com.blins.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;
    public String addTeacher(Teacher teacher) {
         log.info("Saving Data");

        repository.save(teacher);
        
        return new String("Data Saved Successfully");
    }

    public Iterable<Teacher> getTeachers() {
        return repository.findAll();
    }

    public Teacher updateTeacher(Teacher teacher, Long id) {
        Teacher existing_teacher = repository.findById(id).orElse(null);
        existing_teacher.setTsc_number(teacher.getTsc_number());
        existing_teacher.setName(teacher.getName());
        existing_teacher.setSubject(teacher.getSubject());
        existing_teacher.setSchool(teacher.getSchool());

        return repository.save(existing_teacher);
    }

    public void deleteTeacher(Long id) {
        log.info("Deleting Data in database");
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("No Data matching that ID");
        }
    }

    public Teacher getTeacherById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
