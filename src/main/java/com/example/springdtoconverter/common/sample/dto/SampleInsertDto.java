package com.example.springdtoconverter.common.sample.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleInsertDto {
    private String title;
    private String content;
    private boolean useYn;
}
