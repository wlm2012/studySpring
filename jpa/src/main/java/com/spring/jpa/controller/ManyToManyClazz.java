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

            // id不改关系不更新，即使其它参数已经修改，如果不主动更新teacher，则teacher也不更新
            // 如果Set<Teacher> teachers已经改变，则会再次尝试在关系表插入id为10的数据
            Teacher build = Teacher.builder().id(10L).name("10teacher").build();
//            teachers.add(build);

            // 不能加上.id(11L) 会导致teacher的id为自动生成，关系的id则为赋值的值，导致插入失败
            // 没有id的话，自动生成id，并维护关系表
            Teacher build1 = Teacher.builder().name("10teacher").build();
            //如果是关系维护的类维护关系，则会维护关系表，反之不会
            teachers.add(build1);
            build1.setStudents(Set.of(student));

            teacherRepository.save(build1);
            studentRepository.save(student);
        }
    }

    @RequestMapping("/change")
    public void change() {
        Optional<Student> optionalStudent = studentRepository.findById(1L);
        Optional<Teacher> optionalTeacher = teacherRepository.findById(10L);

        if (optionalStudent.isPresent() && optionalTeacher.isPresent()) {
            Student student = optionalStudent.get();
            Teacher teacher = optionalTeacher.get();

            Set<Student> students = new HashSet<>();
            students.add(student);
            Set<Teacher> teachers = new HashSet<>();
            teachers.add(teacher);

            //如果不维护主类的关系，则不会更新关系表
            student.setTeachers(teachers);
            teacher.setStudents(students);

            studentRepository.save(student);
            teacherRepository.save(teacher);

        }


    }


    @RequestMapping("/change1")
    public void change1() {
        Optional<Student> optionalStudent = studentRepository.findById(1L);
        Optional<Teacher> optionalTeacher = teacherRepository.findById(10L);

        if (optionalStudent.isPresent() && optionalTeacher.isPresent()) {
            Student student = optionalStudent.get();
            Teacher teacher = optionalTeacher.get();

            student.getTeachers().add(teacher);
            teacher.getStudents().add(student);

            studentRepository.save(student);
            teacherRepository.save(teacher);

        }
    }
}
