package ru.bruh.bandmanager.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.rest.dto.member.MemberRequest;
import ru.bruh.bandmanager.rest.dto.member.MemberResponse;
import ru.bruh.bandmanager.rest.service.member.MemberService;

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
        return ApiResponse.success(service.delete(name));
    }
}
