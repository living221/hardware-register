package com.example.hardwareregister.computer.service;

import com.example.hardwareregister.computer.ComputerMapper;
import com.example.hardwareregister.computer.computerModel.ComputerModelMapper;
import com.example.hardwareregister.computer.computerModel.dao.ComputerModelRepository;
import com.example.hardwareregister.computer.computerModel.dto.ComputerModelDto;
import com.example.hardwareregister.computer.computerModel.model.ComputerModel;
import com.example.hardwareregister.computer.dao.ComputerRepository;
import com.example.hardwareregister.computer.dto.ComputerDto;
import com.example.hardwareregister.computer.model.Computer;
import com.example.hardwareregister.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.hardwareregister.computer.ComputerMapper.toComputer;
import static com.example.hardwareregister.computer.ComputerMapper.toComputerDto;
import static com.example.hardwareregister.computer.computerModel.ComputerModelMapper.toComputerModel;
import static com.example.hardwareregister.computer.computerModel.ComputerModelMapper.toComputerModelDto;

@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {

    private final ComputerRepository computerRepository;
    private final ComputerModelRepository computerModelRepository;

    @Override
    public ComputerDto addNewComputer(ComputerDto computerDto) {
        Computer computer = toComputer(computerDto);

        return ComputerMapper.toComputerDto(computerRepository.save(computer));
    }

    @Override
    public ComputerDto getComputerById(Long computerId) {
        Optional<Computer> computerById = computerRepository.findById(computerId);

        if (!computerById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Computer with id: %s " +
                    "have not been found.", computerId));
        }

        Computer computer = computerById.get();

        return toComputerDto(computer);
    }

    @Override
    public List<ComputerDto> getAllComputer() {
        return computerRepository.findAll().stream()
                .map(ComputerMapper::toComputerDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComputerModelDto> getComputerModels(Long computerId) {
        Optional<Computer> computerById = computerRepository.findById(computerId);

        if (!computerById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Computer with id: %s " +
                    "have not been found.", computerId));
        }

        return computerModelRepository.findAllByComputer_Id(computerId).stream()
                .map(ComputerModelMapper::toComputerModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public ComputerModelDto addComputerModel(Long computerId, ComputerModelDto computerModelDto) {
        Optional<Computer> computerById = computerRepository.findById(computerId);

        if (!computerById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Computer with id: %s " +
                    "have not been found.", computerId));
        }

        Computer computer = computerById.get();

        ComputerModel computerModel = toComputerModel(computerModelDto);
        computerModel.setComputer(computer);

        return toComputerModelDto(computerModelRepository.save(computerModel));
    }
}
