package ru.bruh.bandmanager.rest.mapper.member.role;

import org.mapstruct.Mapper;
import ru.bruh.bandmanager.model.MemberRole;
import ru.bruh.bandmanager.rest.dto.member.role.MemberRoleRequest;
import ru.bruh.bandmanager.rest.dto.member.role.MemberRoleResponse;

@Mapper(componentModel = "spring")
public interface MemberRoleMapper {

    MemberRole toMemberRole(MemberRoleRequest request);

    MemberRoleResponse toResponse(MemberRole memberRole);
}
