package ru.bruh.bandmanager.rest.dto.hitparade;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChangeBandPositionRequest {

    private String bandName;
    private Long newPosition;
}
