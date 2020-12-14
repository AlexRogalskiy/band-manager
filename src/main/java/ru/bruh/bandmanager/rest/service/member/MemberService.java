package ru.bruh.bandmanager.rest.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;
import ru.bruh.bandmanager.model.Member;
import ru.bruh.bandmanager.rest.dto.member.MemberRequest;
import ru.bruh.bandmanager.rest.dto.member.MemberResponse;
import ru.bruh.bandmanager.rest.mapper.member.MemberMapper;
import ru.bruh.bandmanager.rest.repository.band.BandRepository;
import ru.bruh.bandmanager.rest.repository.member.MemberRepository;
import ru.bruh.bandmanager.rest.repository.member.MemberRoleRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper mapper;

    private final MemberRoleRepository memberRoleRepository;
    private final BandRepository bandRepository;

    public MemberResponse create(MemberRequest request) {
        Member member = mapper.toMember(request);
        member.setMemberRole(memberRoleRepository.findByName(request.getMemberRoleName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.MEMBER_ROLE_NOT_FOUND)));
        member.setBand(bandRepository.findByName(request.getBandName())
                .orElseThrow(() -> new BusinessException(ApiResponseCode.BAND_NOT_FOUND)));

        return mapper.toResponse(memberRepository.save(member));
    }

    public Long delete(String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(() -> new BusinessException(ApiResponseCode.MEMBER_NOT_FOUND));
        Long memberId = member.getId();
        memberRepository.delete(member);
        return memberId;
    }
}
