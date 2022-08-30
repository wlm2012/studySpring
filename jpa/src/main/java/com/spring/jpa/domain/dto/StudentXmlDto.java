package com.spring.jpa.domain.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "req")
public class StudentXmlDto {

    private Integer id;

    private String name;
}
