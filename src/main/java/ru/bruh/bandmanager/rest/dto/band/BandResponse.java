package ru.bruh.bandmanager.rest.dto.band;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.bruh.bandmanager.model.Country;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class BandResponse {

    private Long id;
    private String name;
    private Country country;
    private LocalDateTime formationYear;
}
