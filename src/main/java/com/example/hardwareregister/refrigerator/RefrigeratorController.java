package com.example.hardwareregister.refrigerator;

import com.example.hardwareregister.SortType;
import com.example.hardwareregister.refrigerator.dto.RefrigeratorDto;
import com.example.hardwareregister.refrigerator.refrigeratorModel.dto.RefrigeratorModelDto;
import com.example.hardwareregister.refrigerator.service.RefrigeratorService;
import com.example.hardwareregister.tv.tvModel.dto.TvModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refrigerator")
@RequiredArgsConstructor
public class RefrigeratorController {

    private final RefrigeratorService refrigeratorService;

    @PostMapping
    public RefrigeratorDto addRefrigerator(@RequestBody RefrigeratorDto refrigeratorDto) {
        return refrigeratorService.addNewRefrigerator(refrigeratorDto);
    }

    @GetMapping("/{refrigeratorId}")
    public RefrigeratorDto get(@PathVariable Long refrigeratorId) {
        return refrigeratorService.getRefrigeratorById(refrigeratorId);
    }

    @GetMapping
    public List<RefrigeratorDto> getAll() {
        return refrigeratorService.getAllRefrigerator();
    }

    @GetMapping("/models")
    public List<RefrigeratorModelDto> getRefrigeratorModels(@RequestParam(name = "sort",
            defaultValue = "PRICE_ASC") String sort) {
        SortType sortType = SortType.valueOf(sort);

        return refrigeratorService.getRefrigeratorModels(sortType);
    }

    @GetMapping("/{refrigeratorId}/model")
    public List<RefrigeratorModelDto> getRefrigeratorModelsById(@PathVariable Long refrigeratorId) {
        return refrigeratorService.getRefrigeratorModelsById(refrigeratorId);
    }

    @PostMapping("/{refrigeratorId}/model")
    public RefrigeratorModelDto addRefrigeratorModel(@PathVariable Long refrigeratorId,
                                                     @RequestBody RefrigeratorModelDto refrigeratorModelDto) {
        return refrigeratorService.addRefrigeratorModel(refrigeratorId, refrigeratorModelDto);
    }

    @GetMapping("/search")
    public List<RefrigeratorModelDto> searchTvModels(@RequestParam(name = "text") String text) {
        return refrigeratorService.searchRefrigeratorModels(text);
    }

    @GetMapping("/filter")
    public List<RefrigeratorModelDto> filterTvModels(@RequestParam(name = "colour", defaultValue = "%") String colour,
                                           @RequestParam(name = "size", defaultValue = "0") String size,
                                           @RequestParam(name = "inStock", defaultValue = "true") String inStock,
                                           @RequestParam(name = "doorsCount", defaultValue = "2") Integer doorsCount,
                                           @RequestParam(name = "compressor", defaultValue = "%") String compressor,
                                           @RequestParam(name = "from", defaultValue = "0") String priceFrom,
                                           @RequestParam(name = "to", defaultValue = "max") String priceTo) {
        return refrigeratorService.filterRefrigeratorModels(colour, size, priceFrom, priceTo, inStock, doorsCount, compressor);
    }
}
