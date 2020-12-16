package ru.bruh.bandmanager.rest.dto.tour;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class TourRequest {

    private String name;
    private String bandName;
    private String beginDate;
    private String endDate;
    private String countryName;
    private BigDecimal ticketPrice;
}
