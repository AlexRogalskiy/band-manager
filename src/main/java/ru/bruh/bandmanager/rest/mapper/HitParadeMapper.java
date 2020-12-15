package ru.bruh.bandmanager.rest.mapper;

import org.mapstruct.Mapper;
import ru.bruh.bandmanager.rest.dto.hitparade.HitParadeBandResponse;
import ru.bruh.bandmanager.rest.dto.hitparade.projection.HitParadeBand;

@Mapper(componentModel = "spring")
public interface HitParadeMapper {

    HitParadeBandResponse toResponse(HitParadeBand hitParadeBand);
}
