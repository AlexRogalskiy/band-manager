package ru.bruh.bandmanager.rest.mapper.band;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.rest.dto.band.BandRequest;
import ru.bruh.bandmanager.rest.dto.band.BandResponse;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface BandMapper {

    @Mapping(target = "formationYear", qualifiedByName = "toLocalDateTime")
    Band toBand(BandRequest request);

    BandResponse toBandResponse(Band band);

    @Named("toLocalDateTime")
    default LocalDateTime yearToLocalDateTime(String year) {
        return LocalDateTime.of(Integer.parseInt(year), 2,2,1,1);
    }
}
