package ru.bruh.bandmanager.rest.dto.song;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SongRequest {

    String name;
    String authorName;
    String compositorName;
    String bandName;
    String creationDate;
}
