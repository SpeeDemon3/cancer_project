package com.ruiz.cancer_project.controller.dto;

import com.ruiz.cancer_project.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewRequestDto {
    private String content;
    private Date publicationDate;
    private String img;
    private Long userId;
}
