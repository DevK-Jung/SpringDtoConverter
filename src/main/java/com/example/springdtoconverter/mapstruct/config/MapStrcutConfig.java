package com.example.springdtoconverter.mapstruct.config;

import com.example.springdtoconverter.mapstruct.BaseMapStruct;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@MapperConfig(
        componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = BaseMapStruct.class
)
public interface MapStrcutConfig {
}
