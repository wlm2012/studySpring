package com.spring.webmagic.entityEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ResourcesConverter implements AttributeConverter<ResourcesEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ResourcesEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public ResourcesEnum convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(ResourcesEnum.values())
                .filter(r -> dbData.equals(r.getValue()))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
