package com.example.springdtoconverter.common.sample.dto;

import com.example.springdtoconverter.common.base.dto.BaseRespDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleSelectDto extends BaseRespDto {
    private Long id;
    private String title;
    private String content;
    private boolean useYn;
}
