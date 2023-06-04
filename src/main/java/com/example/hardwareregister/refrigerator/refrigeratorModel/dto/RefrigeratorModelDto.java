package com.example.hardwareregister.refrigerator.refrigeratorModel.dto;

import com.example.hardwareregister.util.Create;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "Информация о модели холодильника")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefrigeratorModelDto {
    @Schema(description = "Идентификатор модели холодильника")
    private Long id;

    @Schema(description = "Модель холодильника")
    @NotBlank(groups = {Create.class}, message = "Model name cannot be empty")
    private String modelName;

    @Schema(description = "Серийный номер модели холодильника")
    @NotBlank(groups = {Create.class}, message = "Serial cannot be empty")
    private String serial;

    @Schema(description = "Цвет холодильника")
    @NotBlank(groups = {Create.class}, message = "Colour cannot be empty")
    private String colour;

    @Schema(description = "Размер холодильника")
    @NotBlank(groups = {Create.class}, message = "Size cannot be empty")
    private Integer size;

    @Schema(description = "Цена холодильника")
    @NotBlank(groups = {Create.class}, message = "price cannot be empty")
    private BigDecimal price;

    @Schema(description = "Количество дверей в холодильнике")
    @NotBlank(groups = {Create.class}, message = "Doors count cannot be empty")
    private Integer doorsCount;

    @Schema(description = "Тип компрессора холодильника")
    @NotBlank(groups = {Create.class}, message = "Compressor type cannot be empty")
    private String compressorType;

    @Schema(description = "Есть ли модель в наличии")
    @NotBlank(groups = {Create.class}, message = "In stock cannot be empty")
    private Boolean inStock;
}
