package com.example.hardwareregister.refrigerator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefrigeratorDto {

    private Long id;

    private String name;

    private String country;

    private String manufacturer;

    private Boolean onlineOrder;

    private Boolean credit;
}
