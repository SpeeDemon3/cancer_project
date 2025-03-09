package com.ruiz.cancer_project.controller.dto;

import com.ruiz.cancer_project.domain.New;
import com.ruiz.cancer_project.entity.NewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    private String name;
    private String email;
    private String pass;
    private String webSite;
    private String img;
    private List<New> news;
}
