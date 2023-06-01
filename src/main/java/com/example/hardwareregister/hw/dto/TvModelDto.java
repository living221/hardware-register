package com.example.hardwareregister.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TvModelDto extends BaseModelDto {

    private String category;

    private String technology;

}
