package com.example.hardwareregister.hoover.service;

import com.example.hardwareregister.hoover.dto.HooverDto;
import com.example.hardwareregister.hoover.hooverModel.dto.HooverModelDto;

import java.util.List;

public interface HooverService {
    HooverDto addNewHoover(HooverDto hooverDto);

    HooverDto getHooverById(Long hooverId);

    List<HooverDto> getAllHoover();

    List<HooverModelDto> getHooverModels(Long hooverId);

    HooverModelDto addHooverModel(Long hooverId, HooverModelDto hooverModelDto);
}
