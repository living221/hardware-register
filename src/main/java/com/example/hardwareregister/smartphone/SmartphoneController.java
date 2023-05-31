package com.example.hardwareregister.smartphone;

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

    @GetMapping("/{smartphoneId}/model")
    public List<SmartphoneModelDto> getSmartphoneModels(@PathVariable Long smartphoneId) {
        return smartphoneService.getSmartphoneModels(smartphoneId);
    }

    @PostMapping("/{smartphoneId}/model")
    public SmartphoneModelDto addSmartphoneModel(@PathVariable Long smartphoneId,
                                                 @RequestBody SmartphoneModelDto smartphoneModelDto) {
        return smartphoneService.addSmartphoneModel(smartphoneId, smartphoneModelDto);
    }

}
