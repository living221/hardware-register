package com.example.hardwareregister.tv;

import com.example.hardwareregister.SortType;
import com.example.hardwareregister.tv.dto.TvDto;
import com.example.hardwareregister.tv.service.TvService;
import com.example.hardwareregister.tv.tvModel.dto.TvModelDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tv")
@RequiredArgsConstructor
@Tag(name = "Вид техники: Телевизоры", description = "Методы для работы с телевизорами")
public class TvController {

    private final TvService tvService;

    @PostMapping
    @Operation(summary = "Добавление новой линейки телевизоров")
    public TvDto addTv(@RequestBody TvDto tvDto) {
        return tvService.addNewTv(tvDto);
    }

    @GetMapping("/{tvId}")
    @Operation(summary = "Линейка телевизоров по его id")
    public TvDto get(
            @Parameter(description = "Id телевизора")
            @PathVariable Long tvId) {
        return tvService.getTvById(tvId);
    }

    @GetMapping
    @Operation(summary = "Все линейки телевизоров")
    public List<TvDto> getAll() {
        return tvService.getAllTv();
    }

    @GetMapping("/models")
    @Operation(summary = "Все модели телевизоров")
    public List<TvModelDto> getTvModels(
            @Parameter(description = "Выбор сортировки моделей: PRICE_ASC, PRICE_DES, ABC, BCA")
            @RequestParam(name = "sort",
                    defaultValue = "PRICE_ASC") String sort) {
        SortType sortType = SortType.valueOf(sort);

        return tvService.getTvModels(sortType);
    }

    @GetMapping("/{tvId}/model")
    @Operation(summary = "Модели телевизора по его id")
    public List<TvModelDto> getTvModels(
            @Parameter(description = "Id телевизора")
            @PathVariable Long tvId) {
        return tvService.getTvModelsByTvId(tvId);
    }

    @PostMapping("/{tvId}/model")
    @Operation(summary = "Добавление модели телевизора по его id")
    public TvModelDto addTvModel(
            @Parameter(description = "Id телевизора")
            @PathVariable Long tvId,
            @RequestBody TvModelDto tvModelDto) {
        return tvService.addTvModel(tvId, tvModelDto);
    }

    @GetMapping("/search")
    @Operation(summary = "Поиск модели телевизора по названию модели")
    public List<TvModelDto> searchTvModels(
            @Parameter(description = "Текст для поиска")
            @RequestParam(name = "text") String text) {
        return tvService.searchTvModels(text);
    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтрация моделей телевизора по параметрам модели")
    public List<TvModelDto> filterTvModels(
            @Parameter(description = "Фильтр по цвету модели")
            @RequestParam(name = "colour", defaultValue = "%") String colour,
            @Parameter(description = "Фильтр по размеру модели")
            @RequestParam(name = "size", defaultValue = "0") String size,
            @Parameter(description = "Фильтр по наличию модели")
            @RequestParam(name = "inStock", defaultValue = "true") String inStock,
            @Parameter(description = "Фильтр по категории")
            @RequestParam(name = "category", defaultValue = "%") String category,
            @Parameter(description = "Фильтр по технологии")
            @RequestParam(name = "tech", defaultValue = "%") String tech,
            @Parameter(description = "Фильтр по минимальной цене")
            @RequestParam(name = "from", defaultValue = "0") String priceFrom,
            @Parameter(description = "Фильтр по максимальной цене")
            @RequestParam(name = "to", defaultValue = "max") String priceTo) {
        return tvService.filterTvModels(colour, size, priceFrom, priceTo, inStock, category, tech);
    }
}
