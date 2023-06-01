package com.example.hardwareregister.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HwDto {
    private Long id;

    private String name;

    private String country;

    private String manufacturer;

    private Boolean onlineOrder;

    private Boolean credit;

    private List<BaseModelDto> comments;
}
