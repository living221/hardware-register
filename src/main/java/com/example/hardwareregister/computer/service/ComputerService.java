package com.example.hardwareregister.computer.service;

import com.example.hardwareregister.computer.computerModel.dto.ComputerModelDto;
import com.example.hardwareregister.computer.dto.ComputerDto;

import java.util.List;

public interface ComputerService {
    ComputerDto addNewComputer(ComputerDto computerDto);

    ComputerDto getComputerById(Long computerId);

    List<ComputerDto> getAllComputer();

    List<ComputerModelDto> getComputerModelsById(Long computerId);

    ComputerModelDto addComputerModel(Long computerId, ComputerModelDto computerModelDto);

    List<ComputerModelDto> getComputerModels();
}
