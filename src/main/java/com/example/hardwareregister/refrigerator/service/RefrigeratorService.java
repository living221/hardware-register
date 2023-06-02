package com.example.hardwareregister.refrigerator.service;

import com.example.hardwareregister.SortType;
import com.example.hardwareregister.refrigerator.dto.RefrigeratorDto;
import com.example.hardwareregister.refrigerator.refrigeratorModel.dto.RefrigeratorModelDto;
import com.example.hardwareregister.tv.tvModel.dto.TvModelDto;

import java.util.List;

public interface RefrigeratorService {
    RefrigeratorDto addNewRefrigerator(RefrigeratorDto refrigeratorDto);

    RefrigeratorDto getRefrigeratorById(Long refrigeratorId);

    List<RefrigeratorDto> getAllRefrigerator();

    List<RefrigeratorModelDto> getRefrigeratorModelsById(Long refrigeratorId);

    RefrigeratorModelDto addRefrigeratorModel(Long refrigeratorId, RefrigeratorModelDto refrigeratorModelDto);

    List<RefrigeratorModelDto> getRefrigeratorModels(SortType sortType);

    List<RefrigeratorModelDto> searchRefrigeratorModels(String text);

    List<RefrigeratorModelDto> filterRefrigeratorModels(String colour,
                                              String size,
                                              String priceFrom,
                                              String priceTo,
                                              String inStock,
                                              Integer doorsCount,
                                              String compressor);
}
