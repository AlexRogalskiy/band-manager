package ru.bruh.bandmanager.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.rest.dto.song.SongRequest;
import ru.bruh.bandmanager.rest.dto.song.SongResponse;
import ru.bruh.bandmanager.rest.service.SongService;

import java.util.Set;

@RestController
@RequestMapping("/song")
@AllArgsConstructor
public class SongController {

    private final SongService service;

    @PostMapping("/create")
    public ApiResponse<SongResponse> create(@RequestBody SongRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @GetMapping
    public ApiResponse<SongResponse> get(@RequestParam String songName) {
        return ApiResponse.success(service.get(songName));
    }

    @GetMapping("/most-popular-band")
    public ApiResponse<Set<SongResponse>> getMostPopularBandSongs() {
        return ApiResponse.success(service.getMostPopularBandSongs());
    }
}
