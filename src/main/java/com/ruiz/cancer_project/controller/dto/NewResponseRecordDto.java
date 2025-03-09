package com.ruiz.cancer_project.controller.dto;

import com.ruiz.cancer_project.domain.User;

import java.util.Date;

public record NewResponseRecordDto(
        Long id,
        String content,
        Date publicationDate,
        String img,
        User user
) {
}
