package com.ruiz.cancer_project.controller.dto;

import com.ruiz.cancer_project.domain.New;

import java.util.List;

public record UserResponseRecordDto(
        Long userId,
        String name,
        String email,
        String pass,
        String webSite,
        String img,
        List<New>news
) {
}
