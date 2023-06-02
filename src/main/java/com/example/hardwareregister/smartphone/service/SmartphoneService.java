package com.example.hardwareregister.smartphone.service;

import com.example.hardwareregister.SortType;
import com.example.hardwareregister.smartphone.dto.SmartphoneDto;
import com.example.hardwareregister.smartphone.smartphoneModel.dto.SmartphoneModelDto;

import java.util.List;

public interface SmartphoneService {
    SmartphoneDto addNewSmartphone(SmartphoneDto smartphoneDto);

    SmartphoneDto getSmartphoneById(Long smartphoneId);

    List<SmartphoneDto> getAllSmartphone();

    List<SmartphoneModelDto> getSmartphoneModelsById(Long smartphoneId);

    SmartphoneModelDto addSmartphoneModel(Long smartphoneId, SmartphoneModelDto smartphoneModelDto);

    List<SmartphoneModelDto> getSmartphoneModels(SortType sortType);

    List<SmartphoneModelDto> searchSmartphoneModels(String text);

    List<SmartphoneModelDto> filterSmartphoneModels(
            String colour,
            String size,
            String priceFrom,
            String priceTo,
            String inStock,
            Integer cameraCount,
            String memory);
}
