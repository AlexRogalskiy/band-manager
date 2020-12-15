package ru.bruh.bandmanager.rest.mapper;

import org.mapstruct.Mapper;
import ru.bruh.bandmanager.model.Country;
import ru.bruh.bandmanager.rest.dto.country.CountryRequest;
import ru.bruh.bandmanager.rest.dto.country.CountryResponse;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    Country toCountry(CountryRequest request);

    CountryResponse toCountryResponse(Country country);
}
