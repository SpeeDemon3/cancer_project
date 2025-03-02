package com.ruiz.cancer_project.service.converter;

import com.ruiz.cancer_project.controller.dto.UserRequestRecordDto;
import com.ruiz.cancer_project.domain.New;
import com.ruiz.cancer_project.domain.User;
import com.ruiz.cancer_project.entity.NewEntity;
import com.ruiz.cancer_project.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public User toUser(UserRequestRecordDto dto) {

        List<New> newList = dto.news().stream()
                .map(newUser -> modelMapper.map(newUser, New.class))
                .collect(Collectors.toList());

        User user = User.builder()
                .userId(null)
                .email(dto.email())
                .pass(dto.pass())
                .webSite(dto.webSite())
                .img(dto.img())
                .news(newList)
                .build();

        log.info("Converter UserEntity to User successfully!!!!");

        return user;
    }

    public UserEntity toUserEntity(UserRequestRecordDto userRequestRecordDto) {

        List<NewEntity> newEntityList = userRequestRecordDto.news().stream()
                .map(newUser -> modelMapper.map(newUser, NewEntity.class))
                .collect(Collectors.toList());

        UserEntity userEntity = new UserEntity(
                null,
                userRequestRecordDto.name(),
                userRequestRecordDto.email(),
                userRequestRecordDto.pass(),
                userRequestRecordDto.webSite(),
                userRequestRecordDto.img(),
                newEntityList
        );

        log.info("Converter UserRequest to UserEntity successfully!!!!");

        return userEntity;

    }

}
