package com.example.hardwareregister.smartphone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmartphoneDto {

    private Long id;

    private String name;

    private String country;

    private String manufacturer;

    private Boolean onlineOrder;

    private Boolean credit;
}
