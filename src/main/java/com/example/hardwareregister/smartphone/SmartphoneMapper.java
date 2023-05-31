package com.example.hardwareregister.smartphone;

import com.example.hardwareregister.smartphone.dto.SmartphoneDto;
import com.example.hardwareregister.smartphone.model.Smartphone;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SmartphoneMapper {
    public static SmartphoneDto toSmartphoneDto(Smartphone smartphone) {
        return SmartphoneDto.builder()
                .id(smartphone.getId())
                .name(smartphone.getName())
                .country(smartphone.getCountry())
                .manufacturer(smartphone.getManufacturer())
                .onlineOrder(smartphone.getOnlineOrder())
                .credit(smartphone.getCredit())
                .build();
    }

    public static Smartphone toSmartphone(SmartphoneDto smartphoneDto) {
        return Smartphone.builder()
                .id(smartphoneDto.getId())
                .name(smartphoneDto.getName())
                .country(smartphoneDto.getCountry())
                .manufacturer(smartphoneDto.getManufacturer())
                .onlineOrder(smartphoneDto.getOnlineOrder())
                .credit(smartphoneDto.getCredit())
                .build();
    }
}
