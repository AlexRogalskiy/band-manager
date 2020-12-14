package ru.bruh.bandmanager.rest.dto.member;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.MemberRole;

@Data
@Accessors(chain = true)
public class MemberResponse {

    private Long id;
    private String name;
    private Band band;
    private Integer age;
    private MemberRole memberRole;
}
