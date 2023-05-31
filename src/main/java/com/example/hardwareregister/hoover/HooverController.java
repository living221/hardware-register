package com.example.hardwareregister.hoover;

import com.example.hardwareregister.hoover.dto.HooverDto;
import com.example.hardwareregister.hoover.hooverModel.dto.HooverModelDto;
import com.example.hardwareregister.hoover.service.HooverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoover")
@RequiredArgsConstructor
public class HooverController {

    private final HooverService hooverService;

    @PostMapping
    public HooverDto addHoover(@RequestBody HooverDto hooverDto) {
        return hooverService.addNewHoover(hooverDto);
    }

    @GetMapping("/{hooverId}")
    public HooverDto get(@PathVariable Long hooverId) {
        return hooverService.getHooverById(hooverId);
    }

    @GetMapping
    public List<HooverDto> getAll() {
        return hooverService.getAllHoover();
    }

    @GetMapping("/{hooverId}/model")
    public List<HooverModelDto> getHooverModels(@PathVariable Long hooverId) {
        return hooverService.getHooverModels(hooverId);
    }

    @PostMapping("/{hooverId}/model")
    public HooverModelDto addHooverModel(@PathVariable Long hooverId,
                                         @RequestBody HooverModelDto hooverModelDto) {
        return hooverService.addHooverModel(hooverId, hooverModelDto);
    }
}
