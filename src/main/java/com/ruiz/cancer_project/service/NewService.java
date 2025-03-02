package com.ruiz.cancer_project.service;

import com.ruiz.cancer_project.controller.dto.NewRequestRecordDto;
import com.ruiz.cancer_project.domain.New;

import java.util.List;

public interface NewService {

    New save(NewRequestRecordDto newRequestRecordDto) throws Exception;
    New findById(Long id) throws Exception;
    List<New> findAll() throws Exception;
    New updateById(Long id, NewRequestRecordDto newRequestRecordDto) throws Exception;
    Boolean deleteByid(Long id) throws Exception;

}
