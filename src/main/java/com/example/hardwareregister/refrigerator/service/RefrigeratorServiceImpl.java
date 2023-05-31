package com.example.hardwareregister.refrigerator.service;

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
    public List<RefrigeratorModelDto> getRefrigeratorModels(Long refrigeratorId) {
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
}
