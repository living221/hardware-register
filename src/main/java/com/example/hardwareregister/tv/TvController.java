package com.example.hardwareregister.tv;

import com.example.hardwareregister.tv.dto.TvDto;
import com.example.hardwareregister.tv.service.TvService;
import com.example.hardwareregister.hw.dto.TvModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tv")
@RequiredArgsConstructor
public class TvController {

    private final TvService tvService;

    @PostMapping
    public TvDto addTv(@RequestBody TvDto tvDto) {
        return tvService.addNewTv(tvDto);
    }

    @GetMapping("/{tvId}")
    public TvDto get(@PathVariable Long tvId) {
        return tvService.getTvById(tvId);
    }

    @GetMapping
    public List<TvDto> getAll() {
        return tvService.getAllTv();
    }

    @GetMapping("/{tvId}/model")
    public List<TvModelDto> getTvModels(@PathVariable Long tvId) {
        return tvService.getTvModels(tvId);
    }

    @PostMapping("/{tvId}/model")
    public TvModelDto addTvModel(@PathVariable Long tvId,
                                 @RequestBody TvModelDto tvModelDto) {
        return tvService.addTvModel(tvId, tvModelDto);
    }
}
