package com.example.hardwareregister.tv.tvModel;

import com.example.hardwareregister.tv.tvModel.dto.TvModelDto;
import com.example.hardwareregister.tv.tvModel.model.TvModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TvModelMapper {
    public static TvModelDto toTvModelDto(TvModel tvModel) {

        return TvModelDto.builder()
                .id(tvModel.getId())
                .modelName(tvModel.getModelName())
                .serial(tvModel.getSerial())
                .colour(tvModel.getColour())
                .size(tvModel.getSize())
                .price(tvModel.getPrice())
                .category(tvModel.getCategory())
                .technology(tvModel.getTechnology())
                .inStock(tvModel.getInStock())
                .build();
    }

    public static TvModel toTvModel(TvModelDto tvModelDto) {

        return TvModel.builder()
                .id(tvModelDto.getId())
                .modelName(tvModelDto.getModelName())
                .serial(tvModelDto.getSerial())
                .colour(tvModelDto.getColour())
                .size(tvModelDto.getSize())
                .price(tvModelDto.getPrice())
                .category(tvModelDto.getCategory())
                .technology(tvModelDto.getTechnology())
                .inStock(tvModelDto.getInStock())
                .build();
    }
}
