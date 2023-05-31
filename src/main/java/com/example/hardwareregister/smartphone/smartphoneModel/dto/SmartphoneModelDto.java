package com.example.hardwareregister.smartphone.smartphoneModel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmartphoneModelDto {

    private Long id;

    private String modelName;

    private String serial;

    private String colour;

    private Integer size;

    private BigDecimal price;

    private String memory;

    private Integer camerasCount;

    private Boolean inStock;
}
