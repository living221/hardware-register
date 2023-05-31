package com.example.hardwareregister.refrigerator.refrigeratorModel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefrigeratorModelDto {

    private Long id;

    private String modelName;

    private String serial;

    private String colour;

    private Integer size;

    private BigDecimal price;

    private Integer doorsCount;

    private String compressorType;

    private Boolean inStock;
}
