package com.example.hardwareregister.hoover.hooverModel;

import com.example.hardwareregister.hoover.hooverModel.dto.HooverModelDto;
import com.example.hardwareregister.hoover.hooverModel.model.HooverModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HooverModelMapper {
    public static HooverModelDto toHooverModelDto(HooverModel hooverModel) {

        return HooverModelDto.builder()
                .id(hooverModel.getId())
                .modelName(hooverModel.getModelName())
                .serial(hooverModel.getSerial())
                .colour(hooverModel.getColour())
                .size(hooverModel.getSize())
                .price(hooverModel.getPrice())
                .dustCapacity(hooverModel.getDustCapacity())
                .modesCount(hooverModel.getModesCount())
                .inStock(hooverModel.getInStock())
                .build();
    }

    public static HooverModel toHooverModel(HooverModelDto hooverModelDto) {

        return HooverModel.builder()
                .id(hooverModelDto.getId())
                .modelName(hooverModelDto.getModelName())
                .serial(hooverModelDto.getSerial())
                .colour(hooverModelDto.getColour())
                .size(hooverModelDto.getSize())
                .price(hooverModelDto.getPrice())
                .dustCapacity(hooverModelDto.getDustCapacity())
                .modesCount(hooverModelDto.getModesCount())
                .inStock(hooverModelDto.getInStock())
                .build();
    }
}
