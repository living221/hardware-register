package com.example.hardwareregister.hoover.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HooverDto {

    private Long id;

    private String name;

    private String country;

    private String manufacturer;

    private Boolean onlineOrder;

    private Boolean credit;
}
