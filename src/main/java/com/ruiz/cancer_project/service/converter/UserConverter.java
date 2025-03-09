package com.ruiz.cancer_project.service.converter;

import com.ruiz.cancer_project.controller.dto.UserRequestDto;
import com.ruiz.cancer_project.controller.dto.UserRequestRecordDto;
import com.ruiz.cancer_project.controller.dto.UserResponseRecordDto;
import com.ruiz.cancer_project.domain.New;
import com.ruiz.cancer_project.domain.User;
import com.ruiz.cancer_project.entity.NewEntity;
import com.ruiz.cancer_project.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public User toUser(UserRequestRecordDto dto) {

        User user = new User();
        user.setEmail(dto.email());
        user.setPass(dto.pass());
        user.setWebSite(dto.webSite());
        user.setImg(dto.img());

        log.info("Converter UserEntity to User successfully!!!!");

        return user;
    }

    public User toUser(UserRequestDto dto) {


        List<New> newList = dto.getNews().stream()
                .map(newUser -> modelMapper.map(newUser, New.class))
                .collect(Collectors.toList());

        if (newList == null) {
            newList = new ArrayList<>();
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPass(dto.getPass());
        user.setWebSite(dto.getWebSite());
        user.setImg(dto.getImg());

        log.info("Converter UserEntity to User successfully!!!!");

        return user;
    }

    public UserResponseRecordDto toUserResponseRecordDto(UserEntity entity) {
        // Mapear la lista de NewEntity a New, manejando el caso en que entity.getNews() sea nulo
        List<NewEntity> newListEntity = entity.getNews();
        List<New> newList = new ArrayList<>();

        if (newListEntity != null) {

            for (NewEntity newEntity : newListEntity) {

                newList.add(modelMapper.map(newEntity, New.class));

            }

        }

        // Crear y devolver el UserResponseRecordDto
        return new UserResponseRecordDto(
                entity.getUserId(), // Asignar el userId correcto
                entity.getName(),
                entity.getEmail(),
                entity.getPass(),
                entity.getWebSite(),
                entity.getImg(),
                newList
        );
    }

    public UserResponseRecordDto toUserResponse(UserRequestDto dto) {


        List<New> newList = dto.getNews().stream()
                .map(newUser -> modelMapper.map(newUser, New.class))
                .collect(Collectors.toList());

        if (newList == null) {
            newList = new ArrayList<>();
            log.info("There are not news.");
        }

        UserResponseRecordDto user = new UserResponseRecordDto(
                null,
                dto.getName(),
                dto.getEmail(),
                dto.getPass(),
                dto.getWebSite(),
                dto.getImg(),
                dto.getNews()
        );

        log.info("Converter UserEntity to User successfully!!!!");

        return user;
    }

    public UserEntity toUserEntity(UserRequestRecordDto userRequestRecordDto) {


        UserEntity userEntity = new UserEntity(
                null,
                userRequestRecordDto.name(),
                userRequestRecordDto.email(),
                userRequestRecordDto.pass(),
                userRequestRecordDto.webSite(),
                userRequestRecordDto.img(),
                null
        );

        log.info("Converter UserRequest to UserEntity successfully!!!!");

        return userEntity;

    }

    public UserResponseRecordDto toUserEntity(UserEntity userEntity) {

        List<New> newList = modelMapper.map(userEntity.getNews(), List.class);

        UserResponseRecordDto userResponseRecordDto = new UserResponseRecordDto(
                userEntity.getUserId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPass(),
                userEntity.getWebSite(),
                userEntity.getImg(),
                newList
        );

        log.info("Converter UserEntity to UserResponseRecordDto successfully!!!!");

        return userResponseRecordDto;

    }

    public User toUser(UserEntity userEntity) {

        User user = new User();

        List<NewEntity> newEntityList = userEntity.getNews();
        List<New> newList = new ArrayList<>();

        user.setUserId(userEntity.getUserId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setPass(userEntity.getPass());
        user.setWebSite(userEntity.getWebSite());
        user.setImg(userEntity.getImg());

        for (NewEntity entity : newEntityList) {
            New news = modelMapper.map(entity, New.class);
            newList.add(news);
        }

        user.setNews(newList);

        return user;
    }



}
