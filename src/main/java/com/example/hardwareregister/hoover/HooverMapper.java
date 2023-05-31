package com.example.hardwareregister.hoover;

import com.example.hardwareregister.hoover.dto.HooverDto;
import com.example.hardwareregister.hoover.model.Hoover;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HooverMapper {
    public static HooverDto toHooverDto(Hoover hoover) {
        return HooverDto.builder()
                .id(hoover.getId())
                .name(hoover.getName())
                .country(hoover.getCountry())
                .manufacturer(hoover.getManufacturer())
                .onlineOrder(hoover.getOnlineOrder())
                .credit(hoover.getCredit())
                .build();
    }

    public static Hoover toHoover(HooverDto hooverDto) {
        return Hoover.builder()
                .id(hooverDto.getId())
                .name(hooverDto.getName())
                .country(hooverDto.getCountry())
                .manufacturer(hooverDto.getManufacturer())
                .onlineOrder(hooverDto.getOnlineOrder())
                .credit(hooverDto.getCredit())
                .build();
    }
}
