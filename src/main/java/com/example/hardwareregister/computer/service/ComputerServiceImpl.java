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
import com.example.hardwareregister.util.SortType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ComputerModelDto> getComputerModelsById(Long computerId) {
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

    @Override
    public List<ComputerModelDto> getComputerModels(SortType sortType) {
        switch (sortType) {
            case PRICE_ASC:
                return computerModelRepository.findByOrderByPriceAsc().stream()
                        .map(ComputerModelMapper::toComputerModelDto)
                        .collect(Collectors.toList());

            case PRICE_DES:
                return computerModelRepository.findByOrderByPriceDesc().stream()
                        .map(ComputerModelMapper::toComputerModelDto)
                        .collect(Collectors.toList());

            case ABC:
                return computerModelRepository.findByOrderByModelNameAsc().stream()
                        .map(ComputerModelMapper::toComputerModelDto)
                        .collect(Collectors.toList());

            case BCA:
                return computerModelRepository.findByOrderByModelNameDesc().stream()
                        .map(ComputerModelMapper::toComputerModelDto)
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Unknown sorting: UNSUPPORTED_SORTING");
        }
    }

    @Override
    public List<ComputerModelDto> searchComputerModels(String text) {
        String textQuery = "%" +
                text.toLowerCase() +
                "%";

        return computerModelRepository.findAllByModelName(textQuery).stream()
                .map(ComputerModelMapper::toComputerModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComputerModelDto> filterTvModels(String colour,
                                                 String sizeString,
                                                 String priceFrom,
                                                 String priceTo,
                                                 String inStock,
                                                 String category,
                                                 String cpuType) {
        int size = Integer.parseInt(sizeString);

        List<ComputerModel> result = new ArrayList<>(computerModelRepository
                .findAllByColourAndSizeAndCategoryAndProcessorType(colour, size, category, cpuType));

        double to;
        if (priceTo.equals("max")) {
            to = 1_000_000_000d;
        } else {
            to = Double.parseDouble(priceTo);
        }

        double from = Double.parseDouble(priceFrom);

        if (from <= to && to > 0.0d) {
            result = result.stream().filter(t -> t.getPrice().doubleValue() < to)
                    .filter(t -> t.getPrice().doubleValue() > from)
                    .collect(Collectors.toList());
        }

        return result.stream()
                .map(ComputerModelMapper::toComputerModelDto)
                .collect(Collectors.toList());
    }
}
