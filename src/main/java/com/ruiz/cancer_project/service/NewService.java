package com.ruiz.cancer_project.service;

import com.ruiz.cancer_project.controller.dto.NewRequestRecordDto;
import com.ruiz.cancer_project.controller.dto.NewResponseDto;
import com.ruiz.cancer_project.controller.dto.NewResponseRecordDto;

import java.util.List;

public interface NewService {

    NewResponseRecordDto save(Long userId, NewRequestRecordDto newRequestRecordDto) throws Exception;
    NewResponseDto findById(Long id) throws Exception;
    List<NewResponseDto> findAll() throws Exception;
    NewResponseRecordDto updateById(Long id, NewRequestRecordDto newRequestRecordDto) throws Exception;
    Boolean deleteByid(Long id) throws Exception;

}
