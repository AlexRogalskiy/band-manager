package ru.bruh.bandmanager.rest.dto.tour.song;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TourSongRequest {

    private String bandName;
    private String songName;
    private String tourName;
}
