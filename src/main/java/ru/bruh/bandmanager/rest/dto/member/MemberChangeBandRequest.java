package ru.bruh.bandmanager.rest.dto.member;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MemberChangeBandRequest {

    private String memberName;
    private String newBandName;
}
