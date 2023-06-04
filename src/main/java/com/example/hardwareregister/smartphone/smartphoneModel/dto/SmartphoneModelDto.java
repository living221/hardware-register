package com.example.hardwareregister.smartphone.smartphoneModel.dto;

import com.example.hardwareregister.util.Create;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "Информация о модели смартфона")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmartphoneModelDto {
    @Schema(description = "Идентификатор модели смартфона")
    private Long id;

    @Schema(description = "Модель смартфона")
    @NotBlank(groups = {Create.class}, message = "Model name cannot be empty")
    private String modelName;

    @Schema(description = "Серийный номер модели смартфона")
    @NotBlank(groups = {Create.class}, message = "Serial cannot be empty")
    private String serial;

    @Schema(description = "Цвет смартфона")
    @NotBlank(groups = {Create.class}, message = "Colour cannot be empty")
    private String colour;

    @Schema(description = "Размер смартфона")
    @NotBlank(groups = {Create.class}, message = "Size cannot be empty")
    private Integer size;

    @Schema(description = "Цена смартфона")
    @NotBlank(groups = {Create.class}, message = "price cannot be empty")
    private BigDecimal price;

    @Schema(description = "Память смартфона")
    @NotBlank(groups = {Create.class}, message = "Memory cannot be empty")
    private String memory;

    @Schema(description = "Количество камер смартфона")
    @NotBlank(groups = {Create.class}, message = "Cameras count cannot be empty")
    private Integer camerasCount;

    @Schema(description = "Есть ли модель в наличии")
    @NotBlank(groups = {Create.class}, message = "In stock cannot be empty")
    private Boolean inStock;
}
