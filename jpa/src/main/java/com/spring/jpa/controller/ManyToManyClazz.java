package com.spring.jpa.controller;

import com.spring.jpa.DO.Student;
import com.spring.jpa.DO.Teacher;
import com.spring.jpa.repository.StudentRepository;
import com.spring.jpa.repository.TeacherRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
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
        Teacher teacherId = teacherRepository.getById(10L);


        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            Set<Teacher> teachers = student.getTeachers();
            for (Teacher teacher : teachers) {
                System.out.println(teacher.getName());
            }

            //更新关系
            Set<Teacher> teacherSet = new HashSet<>();
            teacherSet.add(teacherId);
            student.setTeachers(teacherSet);

            //不更新
            student.setTeachers(teachers);

            //不更新
            teachers.add(teacherId);

            // id不改关系不更新，即使其它参数已经修改，teacher也不更新
//            Teacher build = Teacher.builder().id(10L).name("10teacher").build();
//            teachers.add(build);

            //
            Teacher build1 = Teacher.builder().id(11L).name("10teacher").build();
            teachers.add(build1);
            build1.setStudents(Set.of(student));

            teacherRepository.save(build1);
            studentRepository.save(student);


        }
    }
}
