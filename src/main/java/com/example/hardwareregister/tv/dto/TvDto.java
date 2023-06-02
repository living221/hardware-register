package com.example.hardwareregister.tv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Информация о телевизоре")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TvDto {
    @Schema(description = "Идентификатор телевизора")
    private Long id;
    @Schema(description = "Название линейки телевизоров")
    private String name;
    @Schema(description = "Страна производитель")
    private String country;
    @Schema(description = "Фирма производитель")
    private String manufacturer;
    @Schema(description = "Возможность заказа онлайн")
    private Boolean onlineOrder;
    @Schema(description = "Возможность покупки в кредит")
    private Boolean credit;
}
