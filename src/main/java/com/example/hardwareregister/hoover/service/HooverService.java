package com.example.hardwareregister.hoover.service;

import com.example.hardwareregister.SortType;
import com.example.hardwareregister.hoover.dto.HooverDto;
import com.example.hardwareregister.hoover.hooverModel.dto.HooverModelDto;

import java.util.List;

public interface HooverService {
    HooverDto addNewHoover(HooverDto hooverDto);

    HooverDto getHooverById(Long hooverId);

    List<HooverDto> getAllHoover();

    List<HooverModelDto> getHooverModelsById(Long hooverId);

    HooverModelDto addHooverModel(Long hooverId, HooverModelDto hooverModelDto);

    List<HooverModelDto> getHooverModels(SortType sortType);

    List<HooverModelDto> searchHooverModels(String text);

    List<HooverModelDto> filterHooverModels(String colour,
                                            String size,
                                            String priceFrom,
                                            String priceTo,
                                            String inStock,
                                            Integer dustCapacity,
                                            Integer modesCount);
}
