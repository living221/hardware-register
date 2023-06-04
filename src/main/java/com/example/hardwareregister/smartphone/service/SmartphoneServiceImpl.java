package com.example.hardwareregister.smartphone.service;

import com.example.hardwareregister.util.SortType;
import com.example.hardwareregister.exceptions.ObjectNotFoundException;
import com.example.hardwareregister.smartphone.SmartphoneMapper;
import com.example.hardwareregister.smartphone.dao.SmartphoneRepository;
import com.example.hardwareregister.smartphone.dto.SmartphoneDto;
import com.example.hardwareregister.smartphone.model.Smartphone;
import com.example.hardwareregister.smartphone.smartphoneModel.SmartphoneModelMapper;
import com.example.hardwareregister.smartphone.smartphoneModel.dao.SmartphoneModelRepository;
import com.example.hardwareregister.smartphone.smartphoneModel.dto.SmartphoneModelDto;
import com.example.hardwareregister.smartphone.smartphoneModel.model.SmartphoneModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.hardwareregister.smartphone.SmartphoneMapper.toSmartphone;
import static com.example.hardwareregister.smartphone.SmartphoneMapper.toSmartphoneDto;
import static com.example.hardwareregister.smartphone.smartphoneModel.SmartphoneModelMapper.toSmartphoneModel;
import static com.example.hardwareregister.smartphone.smartphoneModel.SmartphoneModelMapper.toSmartphoneModelDto;

@Service
@RequiredArgsConstructor
public class SmartphoneServiceImpl implements SmartphoneService {

    private final SmartphoneRepository smartphoneRepository;
    private final SmartphoneModelRepository smartphoneModelRepository;

    @Override
    public SmartphoneDto addNewSmartphone(SmartphoneDto smartphoneDto) {
        Smartphone smartphone = toSmartphone(smartphoneDto);

        return SmartphoneMapper.toSmartphoneDto(smartphoneRepository.save(smartphone));
    }

    @Override
    public SmartphoneDto getSmartphoneById(Long smartphoneId) {
        Optional<Smartphone> smartphoneById = smartphoneRepository.findById(smartphoneId);

        if (!smartphoneById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Smartphone with id: %s " +
                    "have not been found.", smartphoneId));
        }

        Smartphone smartphone = smartphoneById.get();

        return toSmartphoneDto(smartphone);
    }

    @Override
    public List<SmartphoneDto> getAllSmartphone() {
        return smartphoneRepository.findAll().stream()
                .map(SmartphoneMapper::toSmartphoneDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SmartphoneModelDto> getSmartphoneModelsById(Long smartphoneId) {
        Optional<Smartphone> smartphoneById = smartphoneRepository.findById(smartphoneId);

        if (!smartphoneById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Smartphone with id: %s " +
                    "have not been found.", smartphoneId));
        }

        return smartphoneModelRepository.findAllBySmartphone_Id(smartphoneId).stream()
                .map(com.example.hardwareregister.smartphone.smartphoneModel.SmartphoneModelMapper::toSmartphoneModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public SmartphoneModelDto addSmartphoneModel(Long smartphoneId, SmartphoneModelDto smartphoneModelDto) {
        Optional<Smartphone> smartphoneById = smartphoneRepository.findById(smartphoneId);

        if (!smartphoneById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Smartphone with id: %s " +
                    "have not been found.", smartphoneId));
        }

        Smartphone smartphone = smartphoneById.get();

        SmartphoneModel smartphoneModel = toSmartphoneModel(smartphoneModelDto);
        smartphoneModel.setSmartphone(smartphone);

        return toSmartphoneModelDto(smartphoneModelRepository.save(smartphoneModel));
    }

    @Override
    public List<SmartphoneModelDto> getSmartphoneModels(SortType sortType) {
        switch (sortType) {
            case PRICE_ASC:
                return smartphoneModelRepository.findByOrderByPriceAsc().stream()
                        .map(SmartphoneModelMapper::toSmartphoneModelDto)
                        .collect(Collectors.toList());

            case PRICE_DES:
                return smartphoneModelRepository.findByOrderByPriceDesc().stream()
                        .map(SmartphoneModelMapper::toSmartphoneModelDto)
                        .collect(Collectors.toList());

            case ABC:
                return smartphoneModelRepository.findByOrderByModelNameAsc().stream()
                        .map(SmartphoneModelMapper::toSmartphoneModelDto)
                        .collect(Collectors.toList());

            case BCA:
                return smartphoneModelRepository.findByOrderByModelNameDesc().stream()
                        .map(SmartphoneModelMapper::toSmartphoneModelDto)
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Unknown sorting: UNSUPPORTED_SORTING");
        }
    }

    @Override
    public List<SmartphoneModelDto> searchSmartphoneModels(String text) {
        String textQuery = "%" +
                text.toLowerCase() +
                "%";

        return smartphoneModelRepository.findAllByModelName(textQuery).stream()
                .map(SmartphoneModelMapper::toSmartphoneModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SmartphoneModelDto> filterSmartphoneModels(String colour,
                                                           String sizeString,
                                                           String priceFrom,
                                                           String priceTo,
                                                           String inStock,
                                                           Integer cameraCount,
                                                           String memory) {
        int size = Integer.parseInt(sizeString);

        List<SmartphoneModel> result = new ArrayList<>(smartphoneModelRepository
                .findAllByColourAndSizeAndCamerasCountAndMemory(colour, size, cameraCount, memory));

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
                .map(SmartphoneModelMapper::toSmartphoneModelDto)
                .collect(Collectors.toList());
    }
}
