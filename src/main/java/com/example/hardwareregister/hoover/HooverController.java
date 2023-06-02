package com.example.hardwareregister.hoover;

import com.example.hardwareregister.SortType;
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

    @GetMapping("/models")
    public List<HooverModelDto> getHooverModels(@RequestParam(name = "sort",
            defaultValue = "PRICE_ASC") String sort) {
        SortType sortType = SortType.valueOf(sort);

        return hooverService.getHooverModels(sortType);
    }

    @GetMapping("/{hooverId}/model")
    public List<HooverModelDto> getHooverModelsById(@PathVariable Long hooverId) {
        return hooverService.getHooverModelsById(hooverId);
    }

    @PostMapping("/{hooverId}/model")
    public HooverModelDto addHooverModel(@PathVariable Long hooverId,
                                         @RequestBody HooverModelDto hooverModelDto) {
        return hooverService.addHooverModel(hooverId, hooverModelDto);
    }

    @GetMapping("/search")
    public List<HooverModelDto> searchHooverModels(@RequestParam(name = "text") String text) {
        return hooverService.searchHooverModels(text);
    }

    @GetMapping("/filter")
    public List<HooverModelDto> filterTvModels(@RequestParam(name = "colour", defaultValue = "%") String colour,
                                           @RequestParam(name = "size", defaultValue = "0") String size,
                                           @RequestParam(name = "inStock", defaultValue = "true") String inStock,
                                           @RequestParam(name = "dustCapacity", defaultValue = "0") Integer dustCapacity,
                                           @RequestParam(name = "modesCount", defaultValue = "0") Integer modesCount,
                                           @RequestParam(name = "from", defaultValue = "0") String priceFrom,
                                           @RequestParam(name = "to", defaultValue = "max") String priceTo) {
        return hooverService.filterHooverModels(colour, size, priceFrom, priceTo, inStock, dustCapacity, modesCount);
    }
}
