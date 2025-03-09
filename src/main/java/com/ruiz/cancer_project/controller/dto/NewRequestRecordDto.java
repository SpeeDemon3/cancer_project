package com.ruiz.cancer_project.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record NewRequestRecordDto(
        String title,
        String content,
        @JsonFormat(pattern = "dd-MM-yy")
        Date publicationDate,
        String img
) {
}
