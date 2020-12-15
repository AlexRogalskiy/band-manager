package ru.bruh.bandmanager.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.HitParade;
import ru.bruh.bandmanager.rest.dto.band.BandResponse;
import ru.bruh.bandmanager.rest.dto.hitparade.ChangeBandPositionRequest;
import ru.bruh.bandmanager.rest.mapper.BandMapper;
import ru.bruh.bandmanager.rest.repository.BandRepository;
import ru.bruh.bandmanager.rest.repository.HitParadeRepository;

@Service
@RequiredArgsConstructor
public class HitParadeService {

    private final HitParadeRepository hitParadeRepository;

    private final BandRepository bandRepository;
    private final BandMapper bandMapper;


    @Transactional
    public BandResponse changeBandPosition(ChangeBandPositionRequest request) {
        Band band = bandRepository.findByName(request.getBandName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND));
        HitParade hitParade = hitParadeRepository.findByBand(band);

        Long currentPosition = hitParade.getPosition();
        Long newPosition = request.getNewPosition();

        if (currentPosition.equals(newPosition)) {
            throw new BusinessException(ApiResponseCode.NEW_HIT_PARADE_POSITION_EQUALS_CURRENT_POSITION);
        }
        if (newPosition >= hitParadeRepository.getLastPosition() || newPosition < 1) {
            throw new BusinessException(ApiResponseCode.INVALID_HIT_PARADE_POSITION);
        }

        if (newPosition > currentPosition) {
            hitParadeRepository.movePositionDown(newPosition, currentPosition);
        } else {
            hitParadeRepository.movePositionUp(newPosition, currentPosition);
        }
        hitParade.setPosition(newPosition);
        return bandMapper.toBandResponse(band);
    }
}
