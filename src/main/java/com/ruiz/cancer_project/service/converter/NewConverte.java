package com.ruiz.cancer_project.service.converter;

import com.ruiz.cancer_project.controller.dto.NewRequestRecordDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class NewConverte {

    @Autowired
    private ModelMapper modelMapper;

    public NewRequestRecordDto toNewRequestRecordDto(NewRequestRecordDto newRequestRecordDto) {



    }

}
