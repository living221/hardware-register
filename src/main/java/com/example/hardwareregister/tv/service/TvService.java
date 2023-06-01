package com.example.hardwareregister.tv.service;

import com.example.hardwareregister.tv.dto.TvDto;
import com.example.hardwareregister.hw.dto.TvModelDto;

import java.util.List;

public interface TvService {
    TvDto addNewTv(TvDto tvDto);

    TvDto getTvById(Long tvId);

    List<TvDto> getAllTv();

    List<TvModelDto> getTvModels(Long tvId);

    TvModelDto addTvModel(Long tvId, TvModelDto tvModelDto);
}
