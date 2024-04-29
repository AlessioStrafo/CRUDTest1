package com.develhope.crudtest1.service;

import com.develhope.crudtest1.entities.Student;
import com.develhope.crudtest1.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepositories studentRepositories;
    public Student setStudentWorkingStatus(Long studentId, boolean isWorking) {
        Optional<Student> student = studentRepositories.findById(studentId);
        if (!student.isPresent()) return null;
        student.get().setWorking(isWorking);
        return studentRepositories.save(student.get());
    }
}
