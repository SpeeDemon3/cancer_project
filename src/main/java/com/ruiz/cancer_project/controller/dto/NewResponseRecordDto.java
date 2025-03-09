package com.ruiz.cancer_project.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruiz.cancer_project.domain.User;

import java.util.Date;

public record NewResponseRecordDto(
        Long id,
        String title,
        String content,
        @JsonFormat(pattern = "dd-MM-yy")
        Date publicationDate,
        String img,
        User user
) {
}
