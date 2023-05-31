package com.example.hardwareregister.hoover.service;

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
    public List<HooverModelDto> getHooverModels(Long hooverId) {
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
}
