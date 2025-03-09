package com.ruiz.cancer_project.service.impl;

import com.ruiz.cancer_project.controller.dto.UserRequestRecordDto;
import com.ruiz.cancer_project.controller.dto.UserResponseRecordDto;
import com.ruiz.cancer_project.domain.User;
import com.ruiz.cancer_project.entity.UserEntity;
import com.ruiz.cancer_project.repository.UserRepository;
import com.ruiz.cancer_project.service.UserService;
import com.ruiz.cancer_project.service.converter.UserConverter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private Logger log = null;

    @Autowired
    private ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public User save(UserRequestRecordDto userRequest) throws Exception {

        UserEntity userEntity = userConverter.toUserEntity(userRequest);

        userRepository.save(userEntity);

        log.info("User created successfully!!!");

        return modelMapper.map(userEntity, User.class);
    }

    @Override
    public List<UserResponseRecordDto> findAll() throws Exception {
        // Obtener la lista de UserEntity desde el repositorio
        List<UserEntity> userListEntity = userRepository.findAll();

        // Verificar si la lista no está vacía
        if (!userListEntity.isEmpty()) {
            log.info("Users found successfully!!!!");

            // Mapear la lista de UserEntity a UserResponseRecordDto
            List<UserResponseRecordDto> userResponseRecordDtoList = userListEntity.stream()
                    .map(userConverter::toUserResponseRecordDto)
                    .collect(Collectors.toList());

            return userResponseRecordDtoList;
        }

        // Si la lista está vacía, devolver una lista vacía
        log.info("No users found.");
        return Collections.emptyList();
    }

    @Override
    public User findById(Long id) throws Exception {

        Optional<UserEntity> userEntity = userRepository.findById(id);

        if (userEntity.isPresent()) {
            return modelMapper.map(userEntity, User.class);
        }

        return null;
    }

    @Override
    public User updateById(Long id, UserRequestRecordDto userRequestRecordDtoUpdate) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) throws Exception {

        if (userRepository.existsById(id)) {

            userRepository.deleteById(id);

            log.info("User successfully deleted");

            return true;
        }

        log.error("User not found!!!");
        return  false;
    }
}
