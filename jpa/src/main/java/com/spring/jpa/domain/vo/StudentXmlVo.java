package com.spring.jpa.domain.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.spring.jpa.domain.dto.StudentXmlDto;
import lombok.Data;

@Data
//@JacksonXmlRootElement(localName = "res")
public class StudentXmlVo {

    private Integer id;

    private String name;

    public static StudentXmlVo fromStudentXmlDto(StudentXmlDto dto) {
        StudentXmlVo studentXmlVo = new StudentXmlVo();
        studentXmlVo.setId(dto.getId());
        studentXmlVo.setName(dto.getName());
        return studentXmlVo;
    }
}
