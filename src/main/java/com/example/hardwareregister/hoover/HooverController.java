package com.example.hardwareregister.hoover;

import com.example.hardwareregister.hoover.dto.HooverDto;
import com.example.hardwareregister.hoover.hooverModel.dto.HooverModelDto;
import com.example.hardwareregister.hoover.service.HooverService;
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

@Tag(name = "Вид техники: Пылесосы", description = "Методы для работы с пылесосами")
@RestController
@RequestMapping("/hoover")
@RequiredArgsConstructor
public class HooverController {

    private final HooverService hooverService;

    @Operation(summary = "Добавление новой линейки пылесосов")
    @PostMapping
    public HooverDto addHoover(@Validated({Create.class})
                               @RequestBody HooverDto hooverDto) {
        return hooverService.addNewHoover(hooverDto);
    }

    @Operation(summary = "Линейка рылесосов по его id")
    @GetMapping("/{hooverId}")
    public HooverDto get(@Parameter(description = "Id пылесоса")
                         @PathVariable Long hooverId) {
        return hooverService.getHooverById(hooverId);
    }

    @Operation(summary = "Все линейки пылесосов")
    @GetMapping
    public List<HooverDto> getAll() {
        return hooverService.getAllHoover();
    }

    @Operation(summary = "Все модели пылесосов")
    @GetMapping("/models")
    public List<HooverModelDto> getHooverModels(
            @Parameter(description = "Выбор сортировки моделей: PRICE_ASC, PRICE_DES, ABC, BCA")
            @RequestParam(name = "sort",
                    defaultValue = "PRICE_ASC") String sort) {
        SortType sortType = SortType.valueOf(sort);

        return hooverService.getHooverModels(sortType);
    }

    @Operation(summary = "Модели пылесоса по его id")
    @GetMapping("/{hooverId}/model")
    public List<HooverModelDto> getHooverModelsById(@Parameter(description = "Id пылесоса")
                                                    @PathVariable Long hooverId) {
        return hooverService.getHooverModelsById(hooverId);
    }

    @Operation(summary = "Добавление модели пылесоса по его id")
    @PostMapping("/{hooverId}/model")
    public HooverModelDto addHooverModel(
            @Parameter(description = "Id пылесоса")
            @PathVariable Long hooverId,
            @Validated({Create.class})
            @RequestBody HooverModelDto hooverModelDto) {
        return hooverService.addHooverModel(hooverId, hooverModelDto);
    }

    @Operation(summary = "Поиск модели пылесоса по названию модели")
    @GetMapping("/search")
    public List<HooverModelDto> searchHooverModels(@Parameter(description = "Текст для поиска")
                                                   @RequestParam(name = "text") String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return Collections.emptyList();
        }

        return hooverService.searchHooverModels(text);
    }

    @Operation(summary = "Фильтрация моделей пылесосов по параметрам модели")
    @GetMapping("/filter")
    public List<HooverModelDto> filterTvModels(
            @Parameter(description = "Фильтр по цвету модели")
            @RequestParam(name = "colour", defaultValue = "%") String colour,
            @Parameter(description = "Фильтр по размеру модели")
            @RequestParam(name = "size", defaultValue = "0") String size,
            @Parameter(description = "Фильтр по наличию модели")
            @RequestParam(name = "inStock", defaultValue = "true") String inStock,
            @Parameter(description = "Фильтр по объему пылесборника")
            @RequestParam(name = "dustCapacity", defaultValue = "0") Integer dustCapacity,
            @Parameter(description = "Фильтр по количеству режимов работы модели")
            @RequestParam(name = "modesCount", defaultValue = "0") Integer modesCount,
            @Parameter(description = "Фильтр по минимальной цене")
            @RequestParam(name = "from", defaultValue = "0") String priceFrom,
            @Parameter(description = "Фильтр по максимальной цене")
            @RequestParam(name = "to", defaultValue = "max") String priceTo) {
        return hooverService.filterHooverModels(colour, size, priceFrom, priceTo, inStock, dustCapacity, modesCount);
    }
}
