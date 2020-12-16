package ru.bruh.bandmanager.rest.dto.member.role;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MemberRoleRequest {

    private String name;
}
