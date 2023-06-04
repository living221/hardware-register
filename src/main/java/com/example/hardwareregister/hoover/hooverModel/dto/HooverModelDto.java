package com.example.hardwareregister.hoover.hooverModel.dto;

import com.example.hardwareregister.util.Create;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "Информация о модели пылесоса")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HooverModelDto {
    @Schema(description = "Идентификатор модели пылесоса")
    private Long id;

    @Schema(description = "Модель пылесоса")
    @NotBlank(groups = {Create.class}, message = "Model name cannot be empty")
    private String modelName;

    @Schema(description = "Серийный номер модели пылесоса")
    @NotBlank(groups = {Create.class}, message = "Serial cannot be empty")
    private String serial;

    @Schema(description = "Цвет рылесоса")
    @NotBlank(groups = {Create.class}, message = "Colour cannot be empty")
    private String colour;

    @Schema(description = "Размер пылесоса")
    @NotBlank(groups = {Create.class}, message = "Size cannot be empty")
    private Integer size;

    @Schema(description = "Цена пылесоса")
    @NotBlank(groups = {Create.class}, message = "price cannot be empty")
    private BigDecimal price;

    @Schema(description = "Размер пылесборника пылесоса")
    @NotBlank(groups = {Create.class}, message = "Dust capacity count cannot be empty")
    private Integer dustCapacity;

    @Schema(description = "Количество режимов работы пылесоса")
    @NotBlank(groups = {Create.class}, message = "Modes count cannot be empty")
    private Integer modesCount;

    @Schema(description = "Есть ли модель в наличии")
    @NotBlank(groups = {Create.class}, message = "In stock cannot be empty")
    private Boolean inStock;
}
