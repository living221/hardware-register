package com.example.hardwareregister.hw.service;

import com.example.hardwareregister.exceptions.ObjectNotFoundException;
import com.example.hardwareregister.hw.HwMapper;
import com.example.hardwareregister.hw.dao.HwRepository;
import com.example.hardwareregister.hw.dao.HwTypeRepository;
import com.example.hardwareregister.hw.dto.HwDto;
import com.example.hardwareregister.hw.model.Hw;
import com.example.hardwareregister.hw.model.HwType;
import com.example.hardwareregister.hw.dto.TvModelDto;
import com.example.hardwareregister.tv.tvModel.dao.TvModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HwServiceImpl implements HwService {

    private final HwTypeRepository hwTypeRepository;

    private final TvModelRepository tvModelRepository;
    private final HwRepository hwRepository;

    @Override
    public HwType addNewHwType(HwType hwType) {
        return hwTypeRepository.save(hwType);
    }

    @Override
    public HwDto addNewHw(Long hwTypeId, HwDto hwDto) {
        Optional<HwType> hwTypeById = hwTypeRepository.findById(hwTypeId);

        if (!hwTypeById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Hardware type with id: %s " +
                    "have not been found.", hwTypeId));
        }

        HwType hwType = hwTypeById.get();

        Hw hw = HwMapper.toHw(hwDto);
        hw.setHwType(hwType);

        return HwMapper.toHwDto(hwRepository.save(hw));
    }

    @Override
    public TvModelDto addTvModel(Long hwTypeId, TvModelDto tvModelDto) {
        Optional<HwType> hwTypeById = hwTypeRepository.findById(hwTypeId);

        if (!hwTypeById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Hardware type with id: %s " +
                    "have not been found.", hwTypeId));
        }

        HwType hwType = hwTypeById.get();

        


        return null;
    }
}
