package com.studyspring.diveinspringboot.autoconfigure.condition;


import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * Java 系统属性名称
     */
    String name();

    /**
     * Java 系统属性值
     */
    String value();
}
