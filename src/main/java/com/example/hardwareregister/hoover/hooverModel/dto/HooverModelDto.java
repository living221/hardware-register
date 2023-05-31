package com.example.hardwareregister.hoover.hooverModel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HooverModelDto {
    private Long id;

    private String modelName;

    private String serial;

    private String colour;

    private Integer size;

    private BigDecimal price;

    private Integer dustCapacity;

    private Integer modesCount;

    private Boolean inStock;
}
