package com.example.hardwareregister.tv.tvModel.dto;

import com.example.hardwareregister.util.Create;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "Информация о модели телевизора")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TvModelDto {
    @Schema(description = "Идентификатор модели телевизора")
    private Long id;

    @Schema(description = "Модель телевизора")
    @NotBlank(groups = {Create.class}, message = "Model name cannot be empty")
    private String modelName;

    @Schema(description = "Серийный номер модели телевизора")
    @NotBlank(groups = {Create.class}, message = "Serial cannot be empty")
    private String serial;

    @Schema(description = "Цвет телевизора")
    @NotBlank(groups = {Create.class}, message = "Colour cannot be empty")
    private String colour;

    @Schema(description = "Размер телевизора")
    @NotBlank(groups = {Create.class}, message = "Size cannot be empty")
    private Integer size;

    @Schema(description = "Цена телевизора")
    @NotBlank(groups = {Create.class}, message = "price cannot be empty")
    private BigDecimal price;

    @Schema(description = "Категория телевизора")
    @NotBlank(groups = {Create.class}, message = "Category cannot be empty")
    private String category;

    @Schema(description = "Технология телевизора")
    @NotBlank(groups = {Create.class}, message = "Technology cannot be empty")
    private String technology;

    @Schema(description = "Есть ли модель в наличии")
    @NotBlank(groups = {Create.class}, message = "In stock cannot be empty")
    private Boolean inStock;
}
