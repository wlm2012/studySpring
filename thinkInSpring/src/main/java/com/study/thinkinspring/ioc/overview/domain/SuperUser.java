package com.study.thinkinspring.ioc.overview.domain;

import com.study.thinkinspring.ioc.overview.annotation.Super;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Super
public class SuperUser extends User {
    private String address;
}
