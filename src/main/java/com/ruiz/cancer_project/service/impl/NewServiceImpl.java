package com.ruiz.cancer_project.service.impl;

import com.ruiz.cancer_project.controller.NewController;
import com.ruiz.cancer_project.controller.UserCotroller;
import com.ruiz.cancer_project.controller.dto.NewRequestDto;
import com.ruiz.cancer_project.controller.dto.NewRequestRecordDto;
import com.ruiz.cancer_project.controller.dto.NewResponseDto;
import com.ruiz.cancer_project.controller.dto.NewResponseRecordDto;
import com.ruiz.cancer_project.service.NewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NewServiceImpl implements NewService {

    private final NewController newController;
    private final UserCotroller userCotroller;

    public NewServiceImpl(NewController newController, UserCotroller userCotroller) {
        this.newController = newController;
        this.userCotroller = userCotroller;
    }

    @Override
    public NewResponseRecordDto save(NewRequestRecordDto newRequestRecordDto) throws Exception {



        return null;
    }

    @Override
    public NewResponseDto findById(Long id) throws Exception {
        return null;
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
        return null;
    }
}
