package ru.bruh.bandmanager.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.rest.dto.country.CountryRequest;
import ru.bruh.bandmanager.rest.dto.country.CountryResponse;
import ru.bruh.bandmanager.rest.mapper.CountryMapper;
import ru.bruh.bandmanager.rest.repository.CountryRepository;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    public CountryResponse create(CountryRequest request) {
        return mapper.toCountryResponse(countryRepository.save(mapper.toCountry(request)));
    }
}
