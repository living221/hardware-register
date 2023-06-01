package com.example.hardwareregister.hw.service;

import com.example.hardwareregister.hw.dto.HwDto;
import com.example.hardwareregister.hw.model.HwType;
import com.example.hardwareregister.hw.dto.TvModelDto;

public interface HwService {
    HwType addNewHwType(HwType hwType);

    HwDto addNewHw(Long hwTypeId, HwDto hwDto);

    TvModelDto addTvModel(Long hwTypeId, TvModelDto tvModelDto);
}
