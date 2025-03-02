package com.ruiz.cancer_project.controller.dto;

import com.ruiz.cancer_project.entity.NewEntity;

import java.util.List;

public record UserResponseRecordDto(
        Long userId,
        String name,
        String email,
        String pass,
        String webSite,
        String img,
        List<NewEntity>news
) {
}
