package com.example.springdtoconverter.mapstruct;

import com.example.springdtoconverter.common.sample.dto.SampleInsertDto;
import com.example.springdtoconverter.common.sample.dto.SampleSelectDto;
import com.example.springdtoconverter.common.sample.dto.SampleUpdateDto;
import com.example.springdtoconverter.common.sample.entity.SampleEntity;
import com.example.springdtoconverter.mapstruct.config.MapStrcutConfig;
import org.mapstruct.Mapper;

@Mapper(config = MapStrcutConfig.class)
public interface SampleMapStruct {
    SampleSelectDto toDto(SampleEntity entity);

    SampleEntity toEntity(SampleInsertDto dto);

    SampleEntity toEntity(SampleUpdateDto dto);
}
