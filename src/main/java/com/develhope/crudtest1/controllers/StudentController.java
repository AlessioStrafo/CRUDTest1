package com.develhope.crudtest1.controllers;

import com.develhope.crudtest1.entities.Student;
import com.develhope.crudtest1.repositories.StudentRepositories;
import com.develhope.crudtest1.service.StudentService;
import io.micrometer.common.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepositories studentRepositories;
    @Autowired
    private StudentService studentService;
    @PostMapping("")
    public @ResponseBody Student create(@RequestBody Student student) {
        return studentRepositories.save(student);
    }
    @GetMapping("/")
    public @ResponseBody List<Student> getList() {
        return studentRepositories.findAll();
    }
    @GetMapping("/{id}")
    public @ResponseBody Student getSingle(@PathVariable Long id) {
        Optional<Student> student = studentRepositories.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }
    @PutMapping("/{id}")
    public @ResponseBody Student update(@PathVariable Long id, @RequestBody @NonNull Student student) {
        student.setId(id);
        student.setName(student.getName());
        student.setSurname(student.getSurname());
        return studentRepositories.save(student);
    }
    @PutMapping("/{id}/working")
    public @ResponseBody Student setStudentWorking(@PathVariable Long id, @RequestParam("working") boolean working) {
        return studentService.setStudentWorkingStatus(id, working);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentRepositories.deleteById(id);
    }
}