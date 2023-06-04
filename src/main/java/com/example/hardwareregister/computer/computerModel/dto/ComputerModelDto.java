package com.example.hardwareregister.computer.computerModel.dto;

import com.example.hardwareregister.util.Create;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "Информация о модели компьютера")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComputerModelDto {
    @Schema(description = "Идентификатор модели компьютера")
    private Long id;

    @Schema(description = "Модель компьютера")
    @NotBlank(groups = {Create.class}, message = "Model name cannot be empty")
    private String modelName;

    @Schema(description = "Серийный номер модели компьютера")
    @NotBlank(groups = {Create.class}, message = "Serial cannot be empty")
    private String serial;

    @Schema(description = "Цвет компьютера")
    @NotBlank(groups = {Create.class}, message = "Colour cannot be empty")
    private String colour;

    @Schema(description = "Размер компьютера")
    @NotBlank(groups = {Create.class}, message = "Size cannot be empty")
    private Integer size;

    @Schema(description = "Цена компьютера")
    @NotBlank(groups = {Create.class}, message = "price cannot be empty")
    private BigDecimal price;

    @Schema(description = "Категория компьютера")
    @NotBlank(groups = {Create.class}, message = "Category cannot be empty")
    private String category;

    @Schema(description = "Тип процессора компьютера")
    @NotBlank(groups = {Create.class}, message = "Processor type cannot be empty")
    private String processorType;

    @Schema(description = "Есть ли модель в наличии")
    @NotBlank(groups = {Create.class}, message = "In stock cannot be empty")
    private Boolean inStock;
}
