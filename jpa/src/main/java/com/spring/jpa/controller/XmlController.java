package com.spring.jpa.controller;

import com.spring.jpa.domain.dto.StudentXmlDto;
import com.spring.jpa.domain.vo.StudentXmlVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class XmlController {


    @PostMapping(value = "/post", consumes = {MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE})
    public StudentXmlVo post(@RequestBody StudentXmlDto dto) {
        dto.setName(dto.getName() + "xml");
        return StudentXmlVo.fromStudentXmlDto(dto);
    }

}
