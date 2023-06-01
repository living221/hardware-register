package com.example.hardwareregister.hw.controller;

import com.example.hardwareregister.hw.dto.HwDto;
import com.example.hardwareregister.hw.model.HwType;
import com.example.hardwareregister.hw.service.HwService;
import com.example.hardwareregister.hw.dto.TvModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hw")
@RequiredArgsConstructor
public class HwController {

    private final HwService hwService;

    @PostMapping("/hwType")
    public HwType addHwType(@RequestBody HwType hwType) {
        return hwService.addNewHwType(hwType);
    }

    @PostMapping("/{hwTypeId}")
    public HwDto addHw(@PathVariable Long hwTypeId,
                       @RequestBody HwDto hwDto) {
        return hwService.addNewHw(hwTypeId, hwDto);
    }

    @PostMapping("/tv/{hwId}/model")
    public TvModelDto addHwModel(@PathVariable Long hwId,
                                 @RequestBody TvModelDto tvModelDto) {
        return hwService.addTvModel(hwId, tvModelDto);
    }

}
