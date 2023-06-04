package com.example.hardwareregister.hoover.service;

import com.example.hardwareregister.util.SortType;
import com.example.hardwareregister.exceptions.ObjectNotFoundException;
import com.example.hardwareregister.hoover.HooverMapper;
import com.example.hardwareregister.hoover.dao.HooverRepository;
import com.example.hardwareregister.hoover.dto.HooverDto;
import com.example.hardwareregister.hoover.hooverModel.HooverModelMapper;
import com.example.hardwareregister.hoover.hooverModel.dao.HooverModelRepository;
import com.example.hardwareregister.hoover.hooverModel.dto.HooverModelDto;
import com.example.hardwareregister.hoover.hooverModel.model.HooverModel;
import com.example.hardwareregister.hoover.model.Hoover;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.hardwareregister.hoover.HooverMapper.toHoover;
import static com.example.hardwareregister.hoover.HooverMapper.toHooverDto;

@Service
@RequiredArgsConstructor
public class HooverServiceImpl implements HooverService {

    private final HooverRepository hooverRepository;
    private final HooverModelRepository hooverModelRepository;

    @Override
    @Transactional
    public HooverDto addNewHoover(HooverDto hooverDto) {
        Hoover hoover = toHoover(hooverDto);

        return toHooverDto(hooverRepository.save(hoover));
    }

    @Override
    @Transactional(readOnly = true)
    public HooverDto getHooverById(Long hooverId) {
        Optional<Hoover> hooverById = hooverRepository.findById(hooverId);

        if (!hooverById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Hoover with id: %s " +
                    "have not been found.", hooverId));
        }

        Hoover hoover = hooverById.get();

        return toHooverDto(hoover);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HooverDto> getAllHoover() {
        return hooverRepository.findAll().stream()
                .map(HooverMapper::toHooverDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<HooverModelDto> getHooverModelsById(Long hooverId) {
        Optional<Hoover> hooverById = hooverRepository.findById(hooverId);

        if (!hooverById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Hoover with id: %s " +
                    "have not been found.", hooverId));
        }

        return hooverModelRepository.findAllByHoover_Id(hooverId).stream()
                .map(HooverModelMapper::toHooverModelDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HooverModelDto addHooverModel(Long hooverId, HooverModelDto hooverModelDto) {
        Optional<Hoover> hooverById = hooverRepository.findById(hooverId);

        if (!hooverById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Hoover with id: %s " +
                    "have not been found.", hooverId));
        }

        Hoover hoover = hooverById.get();

        HooverModel hooverModel = HooverModelMapper.toHooverModel(hooverModelDto);
        hooverModel.setHoover(hoover);

        return HooverModelMapper.toHooverModelDto(hooverModelRepository.save(hooverModel));
    }

    @Override
    public List<HooverModelDto> getHooverModels(SortType sortType) {
        switch (sortType) {
            case PRICE_ASC:
                return hooverModelRepository.findByOrderByPriceAsc().stream()
                        .map(HooverModelMapper::toHooverModelDto)
                        .collect(Collectors.toList());

            case PRICE_DES:
                return hooverModelRepository.findByOrderByPriceDesc().stream()
                        .map(HooverModelMapper::toHooverModelDto)
                        .collect(Collectors.toList());

            case ABC:
                return hooverModelRepository.findByOrderByModelNameAsc().stream()
                        .map(HooverModelMapper::toHooverModelDto)
                        .collect(Collectors.toList());

            case BCA:
                return hooverModelRepository.findByOrderByModelNameDesc().stream()
                        .map(HooverModelMapper::toHooverModelDto)
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Unknown sorting: UNSUPPORTED_SORTING");
        }
    }

    @Override
    public List<HooverModelDto> searchHooverModels(String text) {
        String textQuery = "%" +
                text.toLowerCase() +
                "%";

        return hooverModelRepository.findAllByModelName(textQuery).stream()
                .map(HooverModelMapper::toHooverModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<HooverModelDto> filterHooverModels(String colour,
                                                   String sizeString,
                                                   String priceFrom,
                                                   String priceTo,
                                                   String inStock,
                                                   Integer dustCapacity,
                                                   Integer modesCount) {
        int size = Integer.parseInt(sizeString);


        List<HooverModel> result = new ArrayList<>(hooverModelRepository
                .findAllByColourAndSizeAndDustCapacityAndModesCount(colour, size, dustCapacity, modesCount));

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
                .map(HooverModelMapper::toHooverModelDto)
                .collect(Collectors.toList());
    }
}
