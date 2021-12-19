package com.studyspring.diveinspringboot.autoconfigure.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        assert attributes != null;
        String name = String.valueOf(attributes.get("name"));
        String value = String.valueOf(attributes.get("value"));

        System.out.println("name: " + name);
        System.out.println("value: " + value);
        String property = System.getProperty(name);
        System.out.println("property: " + property);
        return property.equals(value);

    }
}
