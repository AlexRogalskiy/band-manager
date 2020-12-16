package ru.bruh.bandmanager.rest.dto.country;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CountryRequest {

    private String name;
}
