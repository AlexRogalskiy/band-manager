package ru.bruh.bandmanager.rest.dto.tour.song;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import ru.bruh.bandmanager.model.Song;
import ru.bruh.bandmanager.rest.dto.tour.TourResponse;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class TourRecordResponse extends TourResponse {

    List<Song> songs;
}
