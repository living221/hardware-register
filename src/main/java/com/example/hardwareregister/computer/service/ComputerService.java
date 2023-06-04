package com.example.hardwareregister.computer.service;

import com.example.hardwareregister.computer.computerModel.dto.ComputerModelDto;
import com.example.hardwareregister.computer.dto.ComputerDto;
import com.example.hardwareregister.util.SortType;

import java.util.List;

public interface ComputerService {
    ComputerDto addNewComputer(ComputerDto computerDto);

    ComputerDto getComputerById(Long computerId);

    List<ComputerDto> getAllComputer();

    List<ComputerModelDto> getComputerModelsById(Long computerId);

    ComputerModelDto addComputerModel(Long computerId, ComputerModelDto computerModelDto);

    List<ComputerModelDto> getComputerModels(SortType sortType);

    List<ComputerModelDto> searchComputerModels(String text);

    List<ComputerModelDto> filterTvModels(String colour,
                                          String size,
                                          String priceFrom,
                                          String priceTo,
                                          String inStock,
                                          String category,
                                          String cpuType);
}
