package com.example.hardwareregister.smartphone;

import com.example.hardwareregister.SortType;
import com.example.hardwareregister.smartphone.dto.SmartphoneDto;
import com.example.hardwareregister.smartphone.service.SmartphoneService;
import com.example.hardwareregister.smartphone.smartphoneModel.dto.SmartphoneModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smartphone")
@RequiredArgsConstructor
public class SmartphoneController {

    private final SmartphoneService smartphoneService;

    @PostMapping
    public SmartphoneDto addSmartphone(@RequestBody SmartphoneDto smartphoneDto) {
        return smartphoneService.addNewSmartphone(smartphoneDto);
    }

    @GetMapping("/{smartphoneId}")
    public SmartphoneDto get(@PathVariable Long smartphoneId) {
        return smartphoneService.getSmartphoneById(smartphoneId);
    }

    @GetMapping
    public List<SmartphoneDto> getAll() {
        return smartphoneService.getAllSmartphone();
    }

    @GetMapping("/models")
    public List<SmartphoneModelDto> getSmartphoneModels(@RequestParam(name = "sort",
            defaultValue = "PRICE_ASC") String sort) {
        SortType sortType = SortType.valueOf(sort);

        return smartphoneService.getSmartphoneModels(sortType);
    }

    @GetMapping("/{smartphoneId}/model")
    public List<SmartphoneModelDto> getSmartphoneModelsById(@PathVariable Long smartphoneId) {
        return smartphoneService.getSmartphoneModelsById(smartphoneId);
    }

    @PostMapping("/{smartphoneId}/model")
    public SmartphoneModelDto addSmartphoneModel(@PathVariable Long smartphoneId,
                                                 @RequestBody SmartphoneModelDto smartphoneModelDto) {
        return smartphoneService.addSmartphoneModel(smartphoneId, smartphoneModelDto);
    }

    @GetMapping("/search")
    public List<SmartphoneModelDto> searchSmartphoneModels(@RequestParam(name = "text") String text) {
        return smartphoneService.searchSmartphoneModels(text);
    }

    @GetMapping("/filter")
    public List<SmartphoneModelDto> filterSmartphoneModels
            (@RequestParam(name = "colour", defaultValue = "%") String colour,
             @RequestParam(name = "size", defaultValue = "0") String size,
             @RequestParam(name = "inStock", defaultValue = "true") String inStock,
             @RequestParam(name = "cameraCount", defaultValue = "0") Integer cameraCount,
             @RequestParam(name = "memory", defaultValue = "%") String memory,
             @RequestParam(name = "from", defaultValue = "0") String priceFrom,
             @RequestParam(name = "to", defaultValue = "max") String priceTo) {
        return smartphoneService.filterSmartphoneModels(colour, size, priceFrom, priceTo, inStock, cameraCount, memory);
    }
}
