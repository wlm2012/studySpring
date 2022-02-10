package com.study.mybatis.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IsAdultValidator.class})
public @interface IsAdult {


    String message() default "{未成年}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        IsAdult[] value();
    }
}
