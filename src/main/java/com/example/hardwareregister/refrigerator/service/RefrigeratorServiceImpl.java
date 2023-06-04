package com.example.hardwareregister.refrigerator.service;

import com.example.hardwareregister.util.SortType;
import com.example.hardwareregister.exceptions.ObjectNotFoundException;
import com.example.hardwareregister.refrigerator.RefrigeratorMapper;
import com.example.hardwareregister.refrigerator.dao.RefrigeratorRepository;
import com.example.hardwareregister.refrigerator.dto.RefrigeratorDto;
import com.example.hardwareregister.refrigerator.model.Refrigerator;
import com.example.hardwareregister.refrigerator.refrigeratorModel.RefrigeratorModelMapper;
import com.example.hardwareregister.refrigerator.refrigeratorModel.dao.RefrigeratorModelRepository;
import com.example.hardwareregister.refrigerator.refrigeratorModel.dto.RefrigeratorModelDto;
import com.example.hardwareregister.refrigerator.refrigeratorModel.model.RefrigeratorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.hardwareregister.refrigerator.RefrigeratorMapper.toRefrigerator;
import static com.example.hardwareregister.refrigerator.RefrigeratorMapper.toRefrigeratorDto;
import static com.example.hardwareregister.refrigerator.refrigeratorModel.RefrigeratorModelMapper.toRefrigeratorModel;
import static com.example.hardwareregister.refrigerator.refrigeratorModel.RefrigeratorModelMapper.toRefrigeratorModelDto;

@Service
@RequiredArgsConstructor
public class RefrigeratorServiceImpl implements RefrigeratorService {

    private final RefrigeratorRepository refrigeratorRepository;

    private final RefrigeratorModelRepository refrigeratorModelRepository;

    @Override
    public RefrigeratorDto addNewRefrigerator(RefrigeratorDto refrigeratorDto) {
        Refrigerator refrigerator = toRefrigerator(refrigeratorDto);

        return RefrigeratorMapper.toRefrigeratorDto(refrigeratorRepository.save(refrigerator));
    }

    @Override
    public RefrigeratorDto getRefrigeratorById(Long refrigeratorId) {
        Optional<Refrigerator> refrigeratorById = refrigeratorRepository.findById(refrigeratorId);

        if (!refrigeratorById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Refrigerator with id: %s " +
                    "have not been found.", refrigeratorId));
        }

        Refrigerator refrigerator = refrigeratorById.get();

        return toRefrigeratorDto(refrigerator);
    }

    @Override
    public List<RefrigeratorDto> getAllRefrigerator() {
        return refrigeratorRepository.findAll().stream()
                .map(RefrigeratorMapper::toRefrigeratorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RefrigeratorModelDto> getRefrigeratorModelsById(Long refrigeratorId) {
        Optional<Refrigerator> refrigeratorById = refrigeratorRepository.findById(refrigeratorId);

        if (!refrigeratorById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Refrigerator with id: %s " +
                    "have not been found.", refrigeratorId));
        }

        return refrigeratorModelRepository.findAllByRefrigerator_Id(refrigeratorId).stream()
                .map(RefrigeratorModelMapper::toRefrigeratorModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public RefrigeratorModelDto addRefrigeratorModel(Long refrigeratorId, RefrigeratorModelDto refrigeratorModelDto) {
        Optional<Refrigerator> refrigeratorById = refrigeratorRepository.findById(refrigeratorId);

        if (!refrigeratorById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Refrigerator with id: %s " +
                    "have not been found.", refrigeratorId));
        }

        Refrigerator refrigerator = refrigeratorById.get();

        RefrigeratorModel refrigeratorModel = toRefrigeratorModel(refrigeratorModelDto);
        refrigeratorModel.setRefrigerator(refrigerator);

        return toRefrigeratorModelDto(refrigeratorModelRepository.save(refrigeratorModel));
    }

    @Override
    public List<RefrigeratorModelDto> getRefrigeratorModels(SortType sortType) {
        switch (sortType) {
            case PRICE_ASC:
                return refrigeratorModelRepository.findByOrderByPriceAsc().stream()
                        .map(RefrigeratorModelMapper::toRefrigeratorModelDto)
                        .collect(Collectors.toList());

            case PRICE_DES:
                return refrigeratorModelRepository.findByOrderByPriceDesc().stream()
                        .map(RefrigeratorModelMapper::toRefrigeratorModelDto)
                        .collect(Collectors.toList());

            case ABC:
                return refrigeratorModelRepository.findByOrderByModelNameAsc().stream()
                        .map(RefrigeratorModelMapper::toRefrigeratorModelDto)
                        .collect(Collectors.toList());

            case BCA:
                return refrigeratorModelRepository.findByOrderByModelNameDesc().stream()
                        .map(RefrigeratorModelMapper::toRefrigeratorModelDto)
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Unknown sorting: UNSUPPORTED_SORTING");
        }
    }

    @Override
    public List<RefrigeratorModelDto> searchRefrigeratorModels(String text) {
        String textQuery = "%" +
                text.toLowerCase() +
                "%";

        return refrigeratorModelRepository.findAllByModelName(textQuery).stream()
                .map(RefrigeratorModelMapper::toRefrigeratorModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RefrigeratorModelDto> filterRefrigeratorModels(String colour,
                                                     String sizeString,
                                                     String priceFrom,
                                                     String priceTo,
                                                     String inStock,
                                                     Integer doorsCount,
                                                     String compressor) {
        int size = Integer.parseInt(sizeString);

        List<RefrigeratorModel> result = new ArrayList<>(refrigeratorModelRepository
                .findAllByColourAndSizeAndDoorsCountAndCompressorType(colour, size, doorsCount, compressor));

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
                .map(RefrigeratorModelMapper::toRefrigeratorModelDto)
                .collect(Collectors.toList());
    }
}
