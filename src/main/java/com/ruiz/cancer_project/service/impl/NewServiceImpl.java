package com.ruiz.cancer_project.service.impl;

import com.ruiz.cancer_project.controller.NewController;
import com.ruiz.cancer_project.controller.dto.NewRequestRecordDto;
import com.ruiz.cancer_project.controller.dto.NewResponseDto;
import com.ruiz.cancer_project.controller.dto.NewResponseRecordDto;
import com.ruiz.cancer_project.domain.User;
import com.ruiz.cancer_project.entity.NewEntity;
import com.ruiz.cancer_project.entity.UserEntity;
import com.ruiz.cancer_project.repository.NewRepository;
import com.ruiz.cancer_project.service.NewService;
import com.ruiz.cancer_project.service.UserService;
import com.ruiz.cancer_project.service.converter.NewConverte;
import com.ruiz.cancer_project.service.converter.UserConverter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NewServiceImpl implements NewService {

    private final NewRepository newRepository;
    private final UserService userService;
    private final UserConverter userConverter;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NewConverte newConverte;


    public NewServiceImpl(NewRepository newRepository, UserService userService, UserConverter userConverter) {
        this.newRepository = newRepository;
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @Override
    public NewResponseRecordDto save(Long userId, NewRequestRecordDto newRequestRecordDto) throws Exception {

        User userEntityOptional = userService.findById(userId);
        User user = modelMapper.map(userEntityOptional, User.class);


        NewResponseRecordDto responseRecordDto = new NewResponseRecordDto(
                null,
                newRequestRecordDto.title(),
                newRequestRecordDto.content(),
                newRequestRecordDto.publicationDate(),
                newRequestRecordDto.img(),
                user
        );

        NewEntity newEntity = new NewEntity(
                null,
                responseRecordDto.title(),
                responseRecordDto.content(),
                responseRecordDto.publicationDate(),
                responseRecordDto.img(),
                null
                );

        UserEntity userEntity = modelMapper.map(userService.findById(userId), UserEntity.class);
        userEntity.getNews().add(modelMapper.map(newRequestRecordDto, NewEntity.class));
        newEntity.setUser(userEntity);

        newRepository.save(newEntity);

        return responseRecordDto;
    }

    @Override
    public NewResponseDto findById(Long id) throws Exception {

        Optional<NewEntity> newEntityOptional = newRepository.findById(id);

        if(newEntityOptional.isPresent()) {
            log.info("Return new");
            //return modelMapper.map(newEntityOptional.get(), NewResponseDto.class);
            return newConverte.toNewResponseDto(newEntityOptional.get());
        }

        throw new Exception("New not found with id: " + id); // Lanza una excepción si no se encuentra
    }

    @Override
    public List<NewResponseDto> findAll() throws Exception {
        return List.of();
    }

    @Override
    public NewResponseRecordDto updateById(Long id, NewRequestRecordDto newRequestRecordDto) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteByid(Long id) throws Exception {

        Optional<NewEntity> newEntity = newRepository.findById(id);

        if (newEntity.isPresent()) {
            newRepository.deleteById(id);
            return true;
        }

        throw new Exception("New Id not found.");
    }
}
