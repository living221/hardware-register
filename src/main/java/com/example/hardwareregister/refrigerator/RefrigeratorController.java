package com.example.hardwareregister.refrigerator;

import com.example.hardwareregister.refrigerator.dto.RefrigeratorDto;
import com.example.hardwareregister.refrigerator.refrigeratorModel.dto.RefrigeratorModelDto;
import com.example.hardwareregister.refrigerator.service.RefrigeratorService;
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

    @GetMapping("/{refrigeratorId}/model")
    public List<RefrigeratorModelDto> getRefrigeratorModels(@PathVariable Long refrigeratorId) {
        return refrigeratorService.getRefrigeratorModels(refrigeratorId);
    }

    @PostMapping("/{refrigeratorId}/model")
    public RefrigeratorModelDto addRefrigeratorModel(@PathVariable Long refrigeratorId,
                                                     @RequestBody RefrigeratorModelDto refrigeratorModelDto) {
        return refrigeratorService.addRefrigeratorModel(refrigeratorId, refrigeratorModelDto);
    }
}
