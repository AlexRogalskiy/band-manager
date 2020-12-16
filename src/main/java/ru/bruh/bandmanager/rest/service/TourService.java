package ru.bruh.bandmanager.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.Tour;
import ru.bruh.bandmanager.rest.dto.tour.TourRequest;
import ru.bruh.bandmanager.rest.dto.tour.TourResponse;
import ru.bruh.bandmanager.rest.mapper.TourMapper;
import ru.bruh.bandmanager.rest.repository.BandRepository;
import ru.bruh.bandmanager.rest.repository.CountryRepository;
import ru.bruh.bandmanager.rest.repository.TourRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;
    private final TourMapper mapper;

    private final BandRepository bandRepository;
    private final CountryRepository countryRepository;

    public TourResponse create(TourRequest request) {
        Tour tour = mapper.toTour(request);
        if (request.getTicketPrice().intValue() < 1) {
            throw new BusinessException(ApiResponseCode.INVALID_TICKET_PRICE);
        }
        if (tour.getBeginDate().isAfter(tour.getEndDate())) {
            throw new BusinessException(ApiResponseCode.INVALID_TOUR_DATES);
        }

        tour.setBand(bandRepository.findByName(request.getBandName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND)));
        tour.setCountry(countryRepository.findByName(request.getCountryName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.COUNTRY_NOT_FOUND)));
        return mapper.toResponse(tourRepository.save(tour));
    }

    public List<TourResponse> list(String bandName) {
        Band band = bandRepository.findByName(bandName)
                .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND));
        return tourRepository.findAllByBand(band).stream()
                .map(mapper::toResponse).collect(Collectors.toList());
    }
}
