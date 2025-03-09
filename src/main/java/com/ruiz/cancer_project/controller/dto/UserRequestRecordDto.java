package com.ruiz.cancer_project.controller.dto;

public record UserRequestRecordDto(
        String name,
        String email,
        String pass,
        String webSite,
        String img
) {
}
