package com.example.hardwareregister.computer;

import com.example.hardwareregister.computer.computerModel.dto.ComputerModelDto;
import com.example.hardwareregister.computer.dto.ComputerDto;
import com.example.hardwareregister.computer.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @PostMapping
    public ComputerDto addComputer(@RequestBody ComputerDto computerDto) {
        return computerService.addNewComputer(computerDto);
    }

    @GetMapping("/{computerId}")
    public ComputerDto get(@PathVariable Long computerId) {
        return computerService.getComputerById(computerId);
    }

    @GetMapping
    public List<ComputerDto> getAll() {
        return computerService.getAllComputer();
    }

    @GetMapping("/{computerId}/model")
    public List<ComputerModelDto> getComputerModels(@PathVariable Long computerId) {
        return computerService.getComputerModels(computerId);
    }

    @PostMapping("/{computerId}/model")
    public ComputerModelDto addComputerModel(@PathVariable Long computerId,
                                             @RequestBody ComputerModelDto computerModelDto) {
        return computerService.addComputerModel(computerId, computerModelDto);
    }
}
