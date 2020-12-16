package ru.bruh.bandmanager.rest.dto.band;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BandRequest {

    private String name;
    private String countryName;
    private String formationYear;
}
