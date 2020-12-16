package ru.bruh.bandmanager.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.Song;
import ru.bruh.bandmanager.model.Tour;
import ru.bruh.bandmanager.model.TourSong;
import ru.bruh.bandmanager.rest.dto.tour.song.TourRecordResponse;
import ru.bruh.bandmanager.rest.dto.tour.song.TourSongRequest;
import ru.bruh.bandmanager.rest.dto.tour.song.TourSongResponse;
import ru.bruh.bandmanager.rest.mapper.TourMapper;
import ru.bruh.bandmanager.rest.mapper.TourSongMapper;
import ru.bruh.bandmanager.rest.repository.BandRepository;
import ru.bruh.bandmanager.rest.repository.SongRepository;
import ru.bruh.bandmanager.rest.repository.TourRepository;
import ru.bruh.bandmanager.rest.repository.TourSongRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TourSongService {

    private final TourSongRepository tourSongRepository;
    private final TourSongMapper mapper;

    private final BandRepository bandRepository;
    private final SongRepository songRepository;
    private final TourRepository tourRepository;
    private final TourMapper tourMapper;

    public TourSongResponse create(TourSongRequest request) {
        Band band = bandRepository.findByName(request.getBandName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND));
        Song song = songRepository.findByName(request.getSongName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.SONG_NOT_FOUND));
        Tour tour = tourRepository.findByName(request.getTourName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.TOUR_NOT_FOUND));
        if (!song.getBand().equals(band)) {
            throw new BusinessException(ApiResponseCode.SONG_DOES_NOT_BELONG_TO_BAND);
        }
        if (!tour.getBand().equals(band)) {
            throw new BusinessException(ApiResponseCode.TOUR_DOES_NOT_BELONG_TO_BAND);
        }

        TourSong tourSong = mapper.toTourSong(request);
        tourSong.setBand(band);
        tourSong.setSong(song);
        tourSong.setTour(tour);
        return mapper.toResponse(tourSongRepository.save(tourSong));
    }

    public List<TourRecordResponse> songList() {
        return tourRepository.findAll().stream()
                .map(tour -> {
                    TourRecordResponse record = tourMapper.toRecord(tour);
                    return record.setSongs(tourSongRepository.findAllByTour(tour).stream()
                            .map(TourSong::getSong).collect(Collectors.toList()));
                }).collect(Collectors.toList());
    }
}