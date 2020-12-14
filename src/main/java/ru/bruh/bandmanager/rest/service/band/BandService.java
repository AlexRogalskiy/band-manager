package ru.bruh.bandmanager.rest.service.band;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.rest.dto.band.BandRequest;
import ru.bruh.bandmanager.rest.dto.band.BandResponse;
import ru.bruh.bandmanager.rest.mapper.band.BandMapper;
import ru.bruh.bandmanager.rest.repository.band.BandRepository;
import ru.bruh.bandmanager.rest.repository.country.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BandService {

    private final BandRepository bandRepository;
    private final BandMapper mapper;

    private final CountryRepository countryRepository;

    public BandResponse create(BandRequest request) {
        Band band = mapper.toBand(request);
        band.setCountry(countryRepository.findByName(request.getCountryName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.COUNTRY_NOT_FOUND)));

        bandRepository.save(band);
        return mapper.toBandResponse(band);
    }

    public BandResponse get(String name) {
        Band band = bandRepository.findByName(name)
                .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND));

        return mapper.toBandResponse(band);
    }

    public List<BandResponse> getList() {
        return bandRepository.findAll().stream()
                .map(mapper::toBandResponse).collect(Collectors.toList());
    }
}
