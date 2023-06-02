package com.example.hardwareregister.tv.tvModel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String modelName;
    @Schema(description = "Серийный номер модели телевизора")
    private String serial;
    @Schema(description = "Цвет телевизора")
    private String colour;
    @Schema(description = "Размер телевизора")
    private Integer size;
    @Schema(description = "Цена телевизора")
    private BigDecimal price;
    @Schema(description = "Категория телевизора")
    private String category;
    @Schema(description = "Технология телевизора")
    private String technology;
    @Schema(description = "Есть ли модель в наличии")
    private Boolean inStock;
}
