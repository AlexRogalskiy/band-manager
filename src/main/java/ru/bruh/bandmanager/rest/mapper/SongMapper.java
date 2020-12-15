package ru.bruh.bandmanager.rest.mapper;

import org.mapstruct.Mapper;
import ru.bruh.bandmanager.model.Song;
import ru.bruh.bandmanager.rest.dto.song.SongRequest;
import ru.bruh.bandmanager.rest.dto.song.SongResponse;

@Mapper(componentModel = "spring")
public interface SongMapper {

    Song toSong(SongRequest request);

    SongResponse toResponse(Song song);
}
