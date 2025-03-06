package com.example.springdtoconverter.mapstruct;

import com.example.springdtoconverter.common.base.entity.BaseEntity;
import com.example.springdtoconverter.common.base.dto.BaseRespDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface BaseMapStruct {
    void updateBaseDto(@MappingTarget BaseRespDto dto, BaseEntity entity);
}
