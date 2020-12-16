package ru.bruh.bandmanager.rest;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.rest.dto.tour.TourRequest;
import ru.bruh.bandmanager.rest.dto.tour.TourResponse;
import ru.bruh.bandmanager.rest.service.TourService;

import java.util.List;

@RestController
@RequestMapping("/tour")
@AllArgsConstructor
public class TourController {

    private final TourService service;

    @PostMapping("/create")
    public ApiResponse<TourResponse> create(@RequestBody TourRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @GetMapping("/list")
    public ApiResponse<List<TourResponse>> list(@RequestParam String bandName) {
        return ApiResponse.success(service.list(bandName));
    }
}
