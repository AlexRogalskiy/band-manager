package ru.bruh.bandmanager.rest.dto.member;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MemberRequest {

    private String name;
    private String bandName;
    private Integer age;
    private String memberRoleName;
}
