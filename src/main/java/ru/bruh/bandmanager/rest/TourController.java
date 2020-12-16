package ru.bruh.bandmanager.rest;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.rest.dto.tour.TourRequest;
import ru.bruh.bandmanager.rest.dto.tour.TourResponse;
import ru.bruh.bandmanager.rest.dto.tour.song.TourRecordResponse;
import ru.bruh.bandmanager.rest.dto.tour.song.TourSongRequest;
import ru.bruh.bandmanager.rest.dto.tour.song.TourSongResponse;
import ru.bruh.bandmanager.rest.service.TourService;
import ru.bruh.bandmanager.rest.service.TourSongService;

import java.util.List;

@RestController
@RequestMapping("/tour")
@AllArgsConstructor
public class TourController {

    private final TourService service;
    private final TourSongService tourSongService;

    @PostMapping("/create")
    public ApiResponse<TourResponse> create(@RequestBody TourRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @GetMapping("/list")
    public ApiResponse<List<TourResponse>> list(@RequestParam String bandName) {
        return ApiResponse.success(service.list(bandName));
    }

    @PostMapping("/song/create")
    public ApiResponse<TourSongResponse> createSong(@RequestBody TourSongRequest request) {
        return ApiResponse.success(tourSongService.create(request));
    }

    @GetMapping("/song/list")
    public ApiResponse<List<TourRecordResponse>> songList() {
        return ApiResponse.success(tourSongService.songList());
    }
}
