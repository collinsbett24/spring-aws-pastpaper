package com.blins.controllers;

import com.blins.models.Teacher;
import com.blins.repository.TeacherRepository;
import com.blins.services.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService service;

    @PostMapping("/add")
    private ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        service.addTeacher(teacher);
        return new ResponseEntity("Teacher Was Added to table", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public @ResponseBody Iterable<Teacher> getTeacher(){
        return service.getTeachers();
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id){
        service.updateTeacher(teacher, id);
        return new ResponseEntity("Teacher Was Updated in DB", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id){
        service.deleteTeacher(id);
        return new ResponseEntity("Data was deleted", HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    private ResponseEntity<Teacher> getTeacher(@PathVariable Long id){
        return new ResponseEntity(service.getTeacherById(id), HttpStatus.OK);
    }
}
