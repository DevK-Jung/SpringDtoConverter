package com.example.springdtoconverter.common.base.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseRespDto {
    private String regUserId;
    private LocalDateTime regDate;
    private String updateUserId;
    private LocalDateTime updateDate;
}
