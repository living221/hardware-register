package com.example.hardwareregister.computer.computerModel;

import com.example.hardwareregister.computer.computerModel.dto.ComputerModelDto;
import com.example.hardwareregister.computer.computerModel.model.ComputerModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComputerModelMapper {
    public static ComputerModelDto toComputerModelDto(ComputerModel computerModel) {
        return ComputerModelDto.builder()
                .id(computerModel.getId())
                .modelName(computerModel.getModelName())
                .serial(computerModel.getSerial())
                .colour(computerModel.getColour())
                .size(computerModel.getSize())
                .price(computerModel.getPrice())
                .category(computerModel.getCategory())
                .processorType(computerModel.getProcessorType())
                .inStock(computerModel.getInStock())
                .build();
    }

    public static ComputerModel toComputerModel(ComputerModelDto computerModelDto) {
        return ComputerModel.builder()
                .id(computerModelDto.getId())
                .modelName(computerModelDto.getModelName())
                .serial(computerModelDto.getSerial())
                .colour(computerModelDto.getColour())
                .size(computerModelDto.getSize())
                .price(computerModelDto.getPrice())
                .category(computerModelDto.getCategory())
                .processorType(computerModelDto.getProcessorType())
                .inStock(computerModelDto.getInStock())
                .build();
    }
}
