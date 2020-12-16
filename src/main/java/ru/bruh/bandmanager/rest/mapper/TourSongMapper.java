package ru.bruh.bandmanager.rest.mapper;

import org.mapstruct.Mapper;
import ru.bruh.bandmanager.model.TourSong;
import ru.bruh.bandmanager.rest.dto.tour.song.TourSongRequest;
import ru.bruh.bandmanager.rest.dto.tour.song.TourSongResponse;

@Mapper(componentModel = "spring")
public interface TourSongMapper {

    TourSong toTourSong(TourSongRequest request);

    TourSongResponse toResponse(TourSong tourSong);
}
