package com.ruiz.cancer_project.service;

import com.ruiz.cancer_project.controller.dto.UserRequestRecordDto;
import com.ruiz.cancer_project.controller.dto.UserResponseRecordDto;
import com.ruiz.cancer_project.domain.User;

import java.util.List;

public interface UserService {
    User save(UserRequestRecordDto userRequest) throws Exception;
    List<UserResponseRecordDto> findAll() throws Exception;
    User findById(Long id) throws Exception;
    User updateById(Long id, UserRequestRecordDto userRequestRecordDtoUpdate) throws Exception;
    Boolean deleteById(Long id) throws Exception;
}
