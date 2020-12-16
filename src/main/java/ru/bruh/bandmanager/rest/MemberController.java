package ru.bruh.bandmanager.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.common.security.utils.RoleUtils;
import ru.bruh.bandmanager.model.Member;
import ru.bruh.bandmanager.rest.dto.member.MemberChangeBandRequest;
import ru.bruh.bandmanager.rest.dto.member.MemberRequest;
import ru.bruh.bandmanager.rest.dto.member.MemberResponse;
import ru.bruh.bandmanager.rest.service.MemberService;

import java.util.Set;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping("/create")
    public ApiResponse<MemberResponse> create(@RequestBody MemberRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @DeleteMapping
    public ApiResponse<Long> delete(@RequestParam String name) {
        RoleUtils.validateCurrentUserAdmin();
        return ApiResponse.success(service.delete(name));
    }

    @GetMapping("/band-member-list")
    public ApiResponse<Set<Member>> getBandMembers(@RequestParam String bandName) {
        return ApiResponse.success(service.getBandMembers(bandName));
    }

    @PutMapping("/change-band")
    public ApiResponse<MemberResponse> changeBand(@RequestBody MemberChangeBandRequest request) {
        return ApiResponse.success(service.changeBand(request));
    }
}
