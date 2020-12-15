package ru.bruh.bandmanager.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.rest.dto.member.role.MemberRoleRequest;
import ru.bruh.bandmanager.rest.dto.member.role.MemberRoleResponse;
import ru.bruh.bandmanager.rest.mapper.MemberRoleMapper;
import ru.bruh.bandmanager.rest.repository.MemberRoleRepository;

@Service
@RequiredArgsConstructor
public class MemberRoleService {

    private final MemberRoleRepository memberRepository;
    private final MemberRoleMapper mapper;

    public MemberRoleResponse create(MemberRoleRequest request) {
        return mapper.toResponse(memberRepository.save(mapper.toMemberRole(request)));
    }
}
