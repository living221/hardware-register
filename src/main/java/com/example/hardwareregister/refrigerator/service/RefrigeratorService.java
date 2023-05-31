package com.example.hardwareregister.refrigerator.service;

import com.example.hardwareregister.refrigerator.dto.RefrigeratorDto;
import com.example.hardwareregister.refrigerator.refrigeratorModel.dto.RefrigeratorModelDto;

import java.util.List;

public interface RefrigeratorService {
    RefrigeratorDto addNewRefrigerator(RefrigeratorDto refrigeratorDto);

    RefrigeratorDto getRefrigeratorById(Long refrigeratorId);

    List<RefrigeratorDto> getAllRefrigerator();

    List<RefrigeratorModelDto> getRefrigeratorModels(Long refrigeratorId);

    RefrigeratorModelDto addRefrigeratorModel(Long refrigeratorId, RefrigeratorModelDto refrigeratorModelDto);
}
