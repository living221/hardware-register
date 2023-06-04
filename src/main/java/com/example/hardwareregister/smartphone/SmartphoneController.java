package com.example.hardwareregister.smartphone;

import com.example.hardwareregister.smartphone.dto.SmartphoneDto;
import com.example.hardwareregister.smartphone.service.SmartphoneService;
import com.example.hardwareregister.smartphone.smartphoneModel.dto.SmartphoneModelDto;
import com.example.hardwareregister.util.Create;
import com.example.hardwareregister.util.SortType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Tag(name = "Вид техники: Смартфоны", description = "Методы для работы со смартфонами")
@RestController
@RequestMapping("/smartphone")
@RequiredArgsConstructor
public class SmartphoneController {

    private final SmartphoneService smartphoneService;

    @Operation(summary = "Добавление новой линейки смартфонов")
    @PostMapping
    public SmartphoneDto addSmartphone(@Validated({Create.class})
                                       @RequestBody SmartphoneDto smartphoneDto) {
        return smartphoneService.addNewSmartphone(smartphoneDto);
    }

    @Operation(summary = "Линейка смартфонов по его id")
    @GetMapping("/{smartphoneId}")
    public SmartphoneDto get(@Parameter(description = "Id смартфона")
                             @PathVariable Long smartphoneId) {
        return smartphoneService.getSmartphoneById(smartphoneId);
    }

    @Operation(summary = "Все линейки смартфонов")
    @GetMapping
    public List<SmartphoneDto> getAll() {
        return smartphoneService.getAllSmartphone();
    }

    @Operation(summary = "Все модели смартфонов")
    @GetMapping("/models")
    public List<SmartphoneModelDto> getSmartphoneModels(
            @Parameter(description = "Выбор сортировки моделей: PRICE_ASC, PRICE_DES, ABC, BCA")
            @RequestParam(name = "sort",
                    defaultValue = "PRICE_ASC") String sort) {
        SortType sortType = SortType.valueOf(sort);

        return smartphoneService.getSmartphoneModels(sortType);
    }

    @Operation(summary = "Модели смартфона по его id")
    @GetMapping("/{smartphoneId}/model")
    public List<SmartphoneModelDto> getSmartphoneModelsById(
            @Parameter(description = "Id смартфона")
            @PathVariable Long smartphoneId) {
        return smartphoneService.getSmartphoneModelsById(smartphoneId);
    }

    @Operation(summary = "Добавление модели смартфона по его id")
    @PostMapping("/{smartphoneId}/model")
    public SmartphoneModelDto addSmartphoneModel(
            @Parameter(description = "Id смартфона")
            @PathVariable Long smartphoneId,
            @Validated({Create.class})
            @RequestBody SmartphoneModelDto smartphoneModelDto) {
        return smartphoneService.addSmartphoneModel(smartphoneId, smartphoneModelDto);
    }

    @Operation(summary = "Поиск модели смартфона по названию модели")
    @GetMapping("/search")
    public List<SmartphoneModelDto> searchSmartphoneModels(@Parameter(description = "Текст для поиска")
                                                           @RequestParam(name = "text") String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return Collections.emptyList();
        }

        return smartphoneService.searchSmartphoneModels(text);
    }

    @Operation(summary = "Фильтрация моделей смартфонов по параметрам модели")
    @GetMapping("/filter")
    public List<SmartphoneModelDto> filterSmartphoneModels
            (@Parameter(description = "Фильтр по цвету модели")
             @RequestParam(name = "colour", defaultValue = "%") String colour,
             @Parameter(description = "Фильтр по размеру модели")
             @RequestParam(name = "size", defaultValue = "0") String size,
             @Parameter(description = "Фильтр по наличию модели")
             @RequestParam(name = "inStock", defaultValue = "true") String inStock,
             @Parameter(description = "Фильтр по количеству камер модели")
             @RequestParam(name = "cameraCount", defaultValue = "0") Integer cameraCount,
             @Parameter(description = "Фильтр по памяти ")
             @RequestParam(name = "memory", defaultValue = "%") String memory,
             @Parameter(description = "Фильтр по минимальной цене")
             @RequestParam(name = "from", defaultValue = "0") String priceFrom,
             @Parameter(description = "Фильтр по максимальной цене")
             @RequestParam(name = "to", defaultValue = "max") String priceTo) {
        return smartphoneService.filterSmartphoneModels(colour, size, priceFrom, priceTo, inStock, cameraCount, memory);
    }
}
