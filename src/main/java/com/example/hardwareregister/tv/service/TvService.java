package com.example.hardwareregister.tv.service;

import com.example.hardwareregister.SortType;
import com.example.hardwareregister.tv.dto.TvDto;
import com.example.hardwareregister.tv.tvModel.dto.TvModelDto;

import java.util.List;

public interface TvService {
    TvDto addNewTv(TvDto tvDto);

    TvDto getTvById(Long tvId);

    List<TvDto> getAllTv();

    List<TvModelDto> getTvModelsByTvId(Long tvId);

    TvModelDto addTvModel(Long tvId, TvModelDto tvModelDto);

    List<TvModelDto> getTvModels(SortType sortType);

    List<TvModelDto> searchTvModels(String text);

    List<TvModelDto> filterTvModels(String color,
                                    String priceFrom,
                                    String priceTo,
                                    String inStock,
                                    String category,
                                    String tech,
                                    String size);
}
