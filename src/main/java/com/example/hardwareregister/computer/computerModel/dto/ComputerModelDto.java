package com.example.hardwareregister.computer.computerModel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComputerModelDto {
    private Long id;

    private String modelName;

    private String serial;

    private String colour;

    private Integer size;

    private BigDecimal price;

    private String category;

    private String processorType;

    private Boolean inStock;
}
