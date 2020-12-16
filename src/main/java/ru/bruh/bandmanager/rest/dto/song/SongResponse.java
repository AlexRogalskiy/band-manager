package ru.bruh.bandmanager.rest.dto.song;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.Member;

@Data
@Accessors(chain = true)
public class SongResponse {

    private Long id;
    private String name;
    private Member author;
    private Member compositor;
    private Band band;
    private String creationDate;
}
