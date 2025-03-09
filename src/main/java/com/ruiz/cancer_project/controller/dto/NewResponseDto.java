package com.ruiz.cancer_project.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class NewResponseDto {
    private Long id;
    private String title;
    private String content;
    @JsonFormat(pattern = "dd-MM-yy")
    private Date publicationDate;
    private String img;
    private User user;
}
