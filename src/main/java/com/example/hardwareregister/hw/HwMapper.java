package com.example.hardwareregister.hw;

import com.example.hardwareregister.hw.dto.HwDto;
import com.example.hardwareregister.hw.model.Hw;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HwMapper {
    public static HwDto toHwDto(Hw hwDto) {
        return HwDto.builder()
                .id(hwDto.getId())
                .name(hwDto.getName())
                .country(hwDto.getCountry())
                .manufacturer(hwDto.getManufacturer())
                .onlineOrder(hwDto.getOnlineOrder())
                .credit(hwDto.getCredit())
                .build();
    }

    public static Hw toHw(HwDto hwDto) {
        return Hw.builder()
                .id(hwDto.getId())
                .name(hwDto.getName())
                .country(hwDto.getCountry())
                .manufacturer(hwDto.getManufacturer())
                .onlineOrder(hwDto.getOnlineOrder())
                .credit(hwDto.getCredit())
                .build();
    }
}
