package ru.bruh.bandmanager.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.rest.dto.country.CountryRequest;
import ru.bruh.bandmanager.rest.dto.country.CountryResponse;
import ru.bruh.bandmanager.rest.service.country.CountryService;

@RestController
@RequestMapping("/country")
@AllArgsConstructor
public class CountryController {

    private final CountryService service;

    @PostMapping("/create")
    public ApiResponse<CountryResponse> create(@RequestBody CountryRequest request) {
        return ApiResponse.success(service.create(request));
    }
}
