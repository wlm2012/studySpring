package com.spring.webmagic.converter;

import com.spring.webmagic.entityEnum.Inquired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class InquiredConverter implements AttributeConverter<Inquired, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Inquired attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public Inquired convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Inquired.values())
                .filter(a -> a.getValue().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
