package com.example.hardwareregister.refrigerator.refrigeratorModel;

import com.example.hardwareregister.refrigerator.refrigeratorModel.dto.RefrigeratorModelDto;
import com.example.hardwareregister.refrigerator.refrigeratorModel.model.RefrigeratorModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RefrigeratorModelMapper {
    public static RefrigeratorModelDto toRefrigeratorModelDto(RefrigeratorModel refrigeratorModel) {
        return RefrigeratorModelDto.builder()
                .id(refrigeratorModel.getId())
                .modelName(refrigeratorModel.getModelName())
                .serial(refrigeratorModel.getSerial())
                .colour(refrigeratorModel.getColour())
                .size(refrigeratorModel.getSize())
                .price(refrigeratorModel.getPrice())
                .doorsCount(refrigeratorModel.getDoorsCount())
                .compressorType(refrigeratorModel.getCompressorType())
                .inStock(refrigeratorModel.getInStock())
                .build();
    }

    public static RefrigeratorModel toRefrigeratorModel(RefrigeratorModelDto refrigeratorModelDto) {
        return RefrigeratorModel.builder()
                .id(refrigeratorModelDto.getId())
                .modelName(refrigeratorModelDto.getModelName())
                .serial(refrigeratorModelDto.getSerial())
                .colour(refrigeratorModelDto.getColour())
                .size(refrigeratorModelDto.getSize())
                .price(refrigeratorModelDto.getPrice())
                .doorsCount(refrigeratorModelDto.getDoorsCount())
                .compressorType(refrigeratorModelDto.getCompressorType())
                .inStock(refrigeratorModelDto.getInStock())
                .build();
    }
}
