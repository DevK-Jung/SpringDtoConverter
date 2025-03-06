package com.example.springdtoconverter.common.sample.entity;

import com.example.springdtoconverter.common.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleEntity extends BaseEntity {
    private Long id;
    private String title;
    private String content;
    private boolean useYn;

}
