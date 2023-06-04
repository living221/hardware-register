package com.example.hardwareregister.hoover.dto;

import com.example.hardwareregister.util.Create;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Schema(description = "Информация о пылесосе")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HooverDto {
    @Schema(description = "Идентификатор пылесоса")
    private Long id;

    @Schema(description = "Название линейки пылесосов")
    @NotBlank(groups = {Create.class}, message = "Name cannot be empty")
    private String name;

    @Schema(description = "Страна производитель")
    @NotBlank(groups = {Create.class}, message = "country cannot be empty")
    private String country;

    @Schema(description = "Фирма производитель")
    @NotBlank(groups = {Create.class}, message = "manufacturer cannot be empty")
    private String manufacturer;

    @Schema(description = "Возможность заказа онлайн")
    @NotNull(groups = {Create.class}, message = "Online order cannot be null.")
    private Boolean onlineOrder;

    @Schema(description = "Возможность покупки в кредит")
    @NotNull(groups = {Create.class}, message = "credit cannot be null.")
    private Boolean credit;
}
