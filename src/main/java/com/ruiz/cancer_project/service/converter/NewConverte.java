package com.ruiz.cancer_project.service.converter;

import com.ruiz.cancer_project.controller.dto.NewResponseDto;
import com.ruiz.cancer_project.domain.User;
import com.ruiz.cancer_project.entity.NewEntity;
import com.ruiz.cancer_project.entity.UserEntity;
import com.ruiz.cancer_project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@Slf4j
public class NewConverte {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    public NewResponseDto toNewResponseDto(NewEntity entity) throws Exception {

        User userEntityOptional = userService.findById(entity.getId());

        if (userEntityOptional != null) {

            NewResponseDto newResponseDto = NewResponseDto.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .publicationDate(entity.getPublicationDate())
                    .img(null)
                    .user(userEntityOptional)
                    .build();

            return newResponseDto;
        }

        throw new Exception("User not found");
    }

}
