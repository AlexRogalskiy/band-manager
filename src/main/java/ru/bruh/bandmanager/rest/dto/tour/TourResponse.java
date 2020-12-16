package ru.bruh.bandmanager.rest.dto.tour;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.Country;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class TourResponse {

    private Long id;
    private String name;
    private Band band;
    private String beginDate;
    private String endDate;
    private Country country;
    private BigDecimal ticketPrice;
    private Long durationWeeks;
}
