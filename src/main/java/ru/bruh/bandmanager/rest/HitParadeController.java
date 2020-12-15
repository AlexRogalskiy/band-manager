package ru.bruh.bandmanager.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.rest.dto.band.BandResponse;
import ru.bruh.bandmanager.rest.dto.hitparade.ChangeBandPositionRequest;
import ru.bruh.bandmanager.rest.service.HitParadeService;

@RestController
@RequestMapping("/hit-parade")
@AllArgsConstructor
public class HitParadeController {

    private final HitParadeService service;

    @PutMapping("/change-band-position")
    public ApiResponse<BandResponse> changeBandPosition(@RequestBody ChangeBandPositionRequest request) {
        return ApiResponse.success(service.changeBandPosition(request));
    }

}
