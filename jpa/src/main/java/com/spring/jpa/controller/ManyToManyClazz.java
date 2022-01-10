package com.spring.jpa.controller;

import com.spring.jpa.DO.Student;
import com.spring.jpa.DO.Teacher;
import com.spring.jpa.repository.StudentRepository;
import com.spring.jpa.repository.TeacherRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class ManyToManyClazz {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public ManyToManyClazz(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping("/manyToMany")
    public void manyToMany() {

        Optional<Student> optionalStudent = studentRepository.findById(1L);
        Optional<Teacher> optionalTeacher = teacherRepository.findById(10L);
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            Set<Teacher> teachers = student.getTeachers();
            for (Teacher teacher : teachers) {
                System.out.println(teacher.getName());
            }
        }
    }
}
