package com.example.hardwareregister.computer;

import com.example.hardwareregister.computer.computerModel.dto.ComputerModelDto;
import com.example.hardwareregister.computer.dto.ComputerDto;
import com.example.hardwareregister.computer.service.ComputerService;
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

@Tag(name = "Вид техники: Компьютеры", description = "Методы для работы с компьютерами")
@RestController
@RequestMapping("/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @Operation(summary = "Добавление новой линейки компьютеров")
    @PostMapping
    public ComputerDto addComputer(@RequestBody ComputerDto computerDto) {
        return computerService.addNewComputer(computerDto);
    }

    @Operation(summary = "Линейка компьютеров по его id")
    @GetMapping("/{computerId}")
    public ComputerDto get(@Parameter(description = "Id компьютера")
                           @PathVariable Long computerId) {
        return computerService.getComputerById(computerId);
    }

    @Operation(summary = "Все линейки компьютеров")
    @GetMapping
    public List<ComputerDto> getAll() {
        return computerService.getAllComputer();
    }

    @Operation(summary = "Все модели компьютеров")
    @GetMapping("/models")
    public List<ComputerModelDto> getComputerModels(
            @Parameter(description = "Выбор сортировки моделей: PRICE_ASC, PRICE_DES, ABC, BCA")
            @RequestParam(name = "sort",
                    defaultValue = "PRICE_ASC") String sort) {
        SortType sortType = SortType.valueOf(sort);

        return computerService.getComputerModels(sortType);
    }

    @Operation(summary = "Модели компьютера по его id")
    @GetMapping("/{computerId}/model")
    public List<ComputerModelDto> getComputerModelsById(@Parameter(description = "Id компьютера")
                                                        @PathVariable Long computerId) {
        return computerService.getComputerModelsById(computerId);
    }

    @Operation(summary = "Добавление модели компьютера по его id")
    @PostMapping("/{computerId}/model")
    public ComputerModelDto addComputerModel(
            @Parameter(description = "Id компьютера")
            @PathVariable Long computerId,
            @Validated({Create.class})
            @RequestBody ComputerModelDto computerModelDto) {
        return computerService.addComputerModel(computerId, computerModelDto);
    }

    @GetMapping("/search")
    @Operation(summary = "Поиск модели компьютера по названию модели")
    public List<ComputerModelDto> searchComputerModels(
            @Parameter(description = "Текст для поиска")
            @RequestParam(name = "text") String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return Collections.emptyList();
        }

        return computerService.searchComputerModels(text);
    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтрация моделей компьютера по параметрам модели")
    public List<ComputerModelDto> filterTvModels(
            @Parameter(description = "Фильтр по цвету модели")
            @RequestParam(name = "colour", defaultValue = "%") String colour,
            @Parameter(description = "Фильтр по размеру модели")
            @RequestParam(name = "size", defaultValue = "0") String size,
            @Parameter(description = "Фильтр по наличию модели")
            @RequestParam(name = "inStock", defaultValue = "true") String inStock,
            @Parameter(description = "Фильтр по категории")
            @RequestParam(name = "category", defaultValue = "%") String category,
            @Parameter(description = "Фильтр по типу процессора")
            @RequestParam(name = "cpuType", defaultValue = "%") String cpuType,
            @Parameter(description = "Фильтр по минимальной цене")
            @RequestParam(name = "from", defaultValue = "0") String priceFrom,
            @Parameter(description = "Фильтр по максимальной цене")
            @RequestParam(name = "to", defaultValue = "max") String priceTo) {
        return computerService.filterTvModels(colour, size, priceFrom, priceTo, inStock, category, cpuType);
    }
}
