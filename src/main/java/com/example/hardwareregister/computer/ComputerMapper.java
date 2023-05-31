package com.example.hardwareregister.computer;

import com.example.hardwareregister.computer.dto.ComputerDto;
import com.example.hardwareregister.computer.model.Computer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComputerMapper {
    public static ComputerDto toComputerDto(Computer computer) {
        return ComputerDto.builder()
                .id(computer.getId())
                .name(computer.getName())
                .country(computer.getCountry())
                .manufacturer(computer.getManufacturer())
                .onlineOrder(computer.getOnlineOrder())
                .credit(computer.getCredit())
                .build();
    }

    public static Computer toComputer(ComputerDto computerDto) {
        return Computer.builder()
                .id(computerDto.getId())
                .name(computerDto.getName())
                .country(computerDto.getCountry())
                .manufacturer(computerDto.getManufacturer())
                .onlineOrder(computerDto.getOnlineOrder())
                .credit(computerDto.getCredit())
                .build();
    }
}
