package ru.bruh.bandmanager.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.rest.dto.band.BandRequest;
import ru.bruh.bandmanager.rest.dto.band.BandResponse;
import ru.bruh.bandmanager.rest.service.BandService;

import java.util.List;

@RestController
@RequestMapping("/band")
@RequiredArgsConstructor
public class BandController {

    private final BandService service;

    @PostMapping("/create")
    public ApiResponse<BandResponse> create(@RequestBody BandRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @GetMapping
    public ApiResponse<BandResponse> get(@RequestParam String name) {
        return ApiResponse.success(service.get(name));
    }

    @GetMapping("/list")
    public ApiResponse<List<BandResponse>> list() {
        return ApiResponse.success(service.getList());
    }
}
