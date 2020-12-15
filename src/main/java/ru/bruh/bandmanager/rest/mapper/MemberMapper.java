package ru.bruh.bandmanager.rest.mapper;

import org.mapstruct.Mapper;
import ru.bruh.bandmanager.model.Member;
import ru.bruh.bandmanager.rest.dto.member.MemberRequest;
import ru.bruh.bandmanager.rest.dto.member.MemberResponse;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toMember(MemberRequest request);

    MemberResponse toResponse(Member member);
}
