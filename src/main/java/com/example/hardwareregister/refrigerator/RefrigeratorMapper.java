package com.example.hardwareregister.refrigerator;

import com.example.hardwareregister.refrigerator.dto.RefrigeratorDto;
import com.example.hardwareregister.refrigerator.model.Refrigerator;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RefrigeratorMapper {
    public static RefrigeratorDto toRefrigeratorDto(Refrigerator refrigerator) {
        return RefrigeratorDto.builder()
                .id(refrigerator.getId())
                .name(refrigerator.getName())
                .country(refrigerator.getCountry())
                .manufacturer(refrigerator.getManufacturer())
                .onlineOrder(refrigerator.getOnlineOrder())
                .credit(refrigerator.getCredit())
                .build();
    }

    public static Refrigerator toRefrigerator(RefrigeratorDto refrigeratorDto) {
        return Refrigerator.builder()
                .id(refrigeratorDto.getId())
                .name(refrigeratorDto.getName())
                .country(refrigeratorDto.getCountry())
                .manufacturer(refrigeratorDto.getManufacturer())
                .onlineOrder(refrigeratorDto.getOnlineOrder())
                .credit(refrigeratorDto.getCredit())
                .build();
    }
}
