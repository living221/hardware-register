package com.example.hardwareregister.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseModelDto {
    private Long id;

    private String modelName;

    private String serial;

    private String colour;

    private Integer size;

    private BigDecimal price;

    private Boolean inStock;
}
