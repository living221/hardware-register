package com.example.hardwareregister.tv.service;

import com.example.hardwareregister.exceptions.ObjectNotFoundException;
import com.example.hardwareregister.tv.TvMapper;
import com.example.hardwareregister.tv.dao.TvRepository;
import com.example.hardwareregister.tv.dto.TvDto;
import com.example.hardwareregister.tv.model.Tv;
import com.example.hardwareregister.tv.tvModel.TvModelMapper;
import com.example.hardwareregister.tv.tvModel.dao.TvModelRepository;
import com.example.hardwareregister.hw.dto.TvModelDto;
import com.example.hardwareregister.tv.tvModel.model.TvModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.hardwareregister.tv.TvMapper.toTv;
import static com.example.hardwareregister.tv.TvMapper.toTvDto;
import static com.example.hardwareregister.tv.tvModel.TvModelMapper.toTvModel;
import static com.example.hardwareregister.tv.tvModel.TvModelMapper.toTvModelDto;

@Service
@RequiredArgsConstructor
public class TvServiceImpl implements TvService {

    private final TvRepository tvRepository;
    private final TvModelRepository tvModelRepository;

    @Override
    public TvDto addNewTv(TvDto tvDto) {
        Tv tv = toTv(tvDto);

        return toTvDto(tvRepository.save(tv));
    }

    @Override
    public TvDto getTvById(Long tvId) {
        Optional<Tv> tvById = tvRepository.findById(tvId);

        if (!tvById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Tv with id: %s " +
                    "have not been found.", tvId));
        }

        Tv tv = tvById.get();

        return toTvDto(tv);
    }

    @Override
    public List<TvDto> getAllTv() {
        return tvRepository.findAll().stream()
                .map(TvMapper::toTvDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TvModelDto> getTvModels(Long tvId) {
        Optional<Tv> tvById = tvRepository.findById(tvId);

        if (!tvById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Tv with id: %s " +
                    "have not been found.", tvId));
        }

        return tvModelRepository.findAllByTv_Id(tvId).stream()
                .map(TvModelMapper::toTvModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public TvModelDto addTvModel(Long tvId, TvModelDto tvModelDto) {
        Optional<Tv> tvById = tvRepository.findById(tvId);

        if (!tvById.isPresent()) {
            throw new ObjectNotFoundException(String.format("Tv with id: %s " +
                    "have not been found.", tvId));
        }
        Tv tv = tvById.get();

        TvModel tvModel = toTvModel(tvModelDto);
//        tvModel.setTv(tv);

        return toTvModelDto(tvModelRepository.save(tvModel));
    }
}
