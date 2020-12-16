package ru.bruh.bandmanager.rest.dto.hitparade;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HitParadeBandResponse {

    private String name;
    private Long position;
}
