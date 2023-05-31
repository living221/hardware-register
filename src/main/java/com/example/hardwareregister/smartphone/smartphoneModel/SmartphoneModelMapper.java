package com.example.hardwareregister.smartphone.smartphoneModel;

import com.example.hardwareregister.smartphone.smartphoneModel.dto.SmartphoneModelDto;
import com.example.hardwareregister.smartphone.smartphoneModel.model.SmartphoneModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SmartphoneModelMapper {
    public static SmartphoneModelDto toSmartphoneModelDto(SmartphoneModel smartphoneModel) {
        return SmartphoneModelDto.builder()
                .id(smartphoneModel.getId())
                .modelName(smartphoneModel.getModelName())
                .serial(smartphoneModel.getSerial())
                .colour(smartphoneModel.getColour())
                .size(smartphoneModel.getSize())
                .price(smartphoneModel.getPrice())
                .memory(smartphoneModel.getMemory())
                .camerasCount(smartphoneModel.getCamerasCount())
                .inStock(smartphoneModel.getInStock())
                .build();
    }

    public static SmartphoneModel toSmartphoneModel(SmartphoneModelDto smartphoneModelDto) {
        return SmartphoneModel.builder()
                .id(smartphoneModelDto.getId())
                .modelName(smartphoneModelDto.getModelName())
                .serial(smartphoneModelDto.getSerial())
                .colour(smartphoneModelDto.getColour())
                .size(smartphoneModelDto.getSize())
                .price(smartphoneModelDto.getPrice())
                .memory(smartphoneModelDto.getMemory())
                .camerasCount(smartphoneModelDto.getCamerasCount())
                .inStock(smartphoneModelDto.getInStock())
                .build();
    }
}
