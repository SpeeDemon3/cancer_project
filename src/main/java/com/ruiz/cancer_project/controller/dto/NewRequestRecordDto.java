package com.ruiz.cancer_project.controller.dto;

import com.ruiz.cancer_project.domain.User;

import java.util.Date;

public record NewRequestRecordDto(
        String content,
        Date publicationDate,
        String img,
        Long  userId
) {
}
