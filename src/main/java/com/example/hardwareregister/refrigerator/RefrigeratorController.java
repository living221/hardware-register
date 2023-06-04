package com.example.hardwareregister.refrigerator;

import com.example.hardwareregister.refrigerator.dto.RefrigeratorDto;
import com.example.hardwareregister.refrigerator.refrigeratorModel.dto.RefrigeratorModelDto;
import com.example.hardwareregister.refrigerator.service.RefrigeratorService;
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

@Tag(name = "Вид техники: Холодильники", description = "Методы для работы с холодильниками")
@RestController
@RequestMapping("/refrigerator")
@RequiredArgsConstructor
public class RefrigeratorController {

    private final RefrigeratorService refrigeratorService;

    @Operation(summary = "Добавление новой линейки холодильников")
    @PostMapping
    public RefrigeratorDto addRefrigerator(@Validated({Create.class})
                                           @RequestBody RefrigeratorDto refrigeratorDto) {
        return refrigeratorService.addNewRefrigerator(refrigeratorDto);
    }

    @Operation(summary = "Линейка холодильников по его id")
    @GetMapping("/{refrigeratorId}")
    public RefrigeratorDto get(@Parameter(description = "Id холодильника")
                               @PathVariable Long refrigeratorId) {
        return refrigeratorService.getRefrigeratorById(refrigeratorId);
    }

    @Operation(summary = "Все линейки холодильников")
    @GetMapping
    public List<RefrigeratorDto> getAll() {
        return refrigeratorService.getAllRefrigerator();
    }

    @Operation(summary = "Все модели холодильников")
    @GetMapping("/models")
    public List<RefrigeratorModelDto> getRefrigeratorModels(
            @Parameter(description = "Выбор сортировки моделей: PRICE_ASC, PRICE_DES, ABC, BCA")
            @RequestParam(name = "sort",
                    defaultValue = "PRICE_ASC") String sort) {
        SortType sortType = SortType.valueOf(sort);

        return refrigeratorService.getRefrigeratorModels(sortType);
    }

    @Operation(summary = "Модели холодильника по его id")
    @GetMapping("/{refrigeratorId}/model")
    public List<RefrigeratorModelDto> getRefrigeratorModelsById(@Parameter(description = "Id холодильника")
                                                                @PathVariable Long refrigeratorId) {
        return refrigeratorService.getRefrigeratorModelsById(refrigeratorId);
    }

    @Operation(summary = "Добавление модели холодильника по его id")
    @PostMapping("/{refrigeratorId}/model")
    public RefrigeratorModelDto addRefrigeratorModel(
            @Parameter(description = "Id смартфона")
            @PathVariable Long refrigeratorId,
            @Validated({Create.class})
            @RequestBody RefrigeratorModelDto refrigeratorModelDto) {
        return refrigeratorService.addRefrigeratorModel(refrigeratorId, refrigeratorModelDto);
    }

    @Operation(summary = "Поиск модели холодильника по названию модели")
    @GetMapping("/search")
    public List<RefrigeratorModelDto> searchTvModels(@Parameter(description = "Текст для поиска")
                                                     @RequestParam(name = "text") String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return Collections.emptyList();
        }

        return refrigeratorService.searchRefrigeratorModels(text);
    }

    @Operation(summary = "Фильтрация моделей холодильников по параметрам модели")
    @GetMapping("/filter")
    public List<RefrigeratorModelDto> filterTvModels(
            @Parameter(description = "Фильтр по цвету модели")
            @RequestParam(name = "colour", defaultValue = "%") String colour,
            @Parameter(description = "Фильтр по размеру модели")
            @RequestParam(name = "size", defaultValue = "0") String size,
            @Parameter(description = "Фильтр по наличию модели")
            @RequestParam(name = "inStock", defaultValue = "true") String inStock,
            @Parameter(description = "Фильтр по количеству дверей модели")
            @RequestParam(name = "doorsCount", defaultValue = "2") Integer doorsCount,
            @Parameter(description = "Фильтр по типу компрессора")
            @RequestParam(name = "compressor", defaultValue = "%") String compressor,
            @Parameter(description = "Фильтр по минимальной цене")
            @RequestParam(name = "from", defaultValue = "0") String priceFrom,
            @Parameter(description = "Фильтр по максимальной цене")
            @RequestParam(name = "to", defaultValue = "max") String priceTo) {
        return refrigeratorService.filterRefrigeratorModels(colour, size, priceFrom, priceTo, inStock, doorsCount, compressor);
    }
}
