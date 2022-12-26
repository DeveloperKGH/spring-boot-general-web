package com.kgh.web.global.domain.enums.converter;

import com.kgh.web.global.domain.enums.MemberRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MemberRoleConverter implements AttributeConverter<MemberRole, String> {
    @Override
    public String convertToDatabaseColumn(MemberRole attribute) {
        return attribute.name();
    }

    @Override
    public MemberRole convertToEntityAttribute(String dbData) {
        return MemberRole.valueOf(dbData);
    }
}
