package com.example.hardwareregister.smartphone.service;

import com.example.hardwareregister.smartphone.dto.SmartphoneDto;
import com.example.hardwareregister.smartphone.smartphoneModel.dto.SmartphoneModelDto;

import java.util.List;

public interface SmartphoneService {
    SmartphoneDto addNewSmartphone(SmartphoneDto smartphoneDto);

    SmartphoneDto getSmartphoneById(Long smartphoneId);

    List<SmartphoneDto> getAllSmartphone();

    List<SmartphoneModelDto> getSmartphoneModels(Long smartphoneId);

    SmartphoneModelDto addSmartphoneModel(Long smartphoneId, SmartphoneModelDto smartphoneModelDto);
}
