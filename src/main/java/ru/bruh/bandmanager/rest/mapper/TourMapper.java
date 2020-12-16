package ru.bruh.bandmanager.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.bruh.bandmanager.model.Tour;
import ru.bruh.bandmanager.rest.dto.tour.TourRequest;
import ru.bruh.bandmanager.rest.dto.tour.TourResponse;
import ru.bruh.bandmanager.rest.dto.tour.song.TourRecordResponse;

import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public interface TourMapper {

    Tour toTour(TourRequest request);

    @Mapping(target = "durationWeeks", source = "tour", qualifiedByName = "getDurationWeeks")
    TourResponse toResponse(Tour tour);


    TourRecordResponse toRecord(Tour tour);

    @Named("getDurationWeeks")
    default Long getDurationWeeks(Tour tour) {
        return ChronoUnit.WEEKS.between(tour.getBeginDate(), tour.getEndDate());
    }
}
