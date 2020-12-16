package ru.bruh.bandmanager.rest.dto.tour.song;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.Song;
import ru.bruh.bandmanager.model.Tour;

@Data
@Accessors(chain = true)
public class TourSongResponse {

    private Long id;
    private Band band;
    private Song song;
    private Tour tour;
}
