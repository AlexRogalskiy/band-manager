package ru.bruh.bandmanager.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;
import ru.bruh.bandmanager.model.Song;
import ru.bruh.bandmanager.rest.dto.song.SongRequest;
import ru.bruh.bandmanager.rest.dto.song.SongResponse;
import ru.bruh.bandmanager.rest.mapper.SongMapper;
import ru.bruh.bandmanager.rest.repository.BandRepository;
import ru.bruh.bandmanager.rest.repository.HitParadeRepository;
import ru.bruh.bandmanager.rest.repository.MemberRepository;
import ru.bruh.bandmanager.rest.repository.SongRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper mapper;

    private final MemberRepository memberRepository;
    private final BandRepository bandRepository;
    private final HitParadeRepository hitParadeRepository;

    public SongResponse create(SongRequest request) {
        Song song = mapper.toSong(request);
        song.setAuthor(memberRepository.findByName(request.getAuthorName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.MEMBER_NOT_FOUND)));
        song.setCompositor(memberRepository.findByName(request.getCompositorName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.MEMBER_NOT_FOUND)));
        song.setBand(bandRepository.findByName(request.getBandName())
          .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND)));
        return mapper.toResponse(songRepository.save(song));
    }

    public SongResponse get(String songName) {
        return mapper.toResponse(songRepository.findByName(songName)
                .orElseThrow(() -> new BusinessException(ApiResponseCode.SONG_NOT_FOUND)));
    }

    public Set<SongResponse> getMostPopularBandSongs() {
        Long mostPopularBandId = hitParadeRepository.findByPosition(1L)
                .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND)).getBand().getId();
        return songRepository.findAllByBand(bandRepository.findById(mostPopularBandId)
                .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND)))
                .stream().map(mapper::toResponse).collect(Collectors.toSet());
    }
}
