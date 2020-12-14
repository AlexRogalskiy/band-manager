package ru.bruh.bandmanager.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.rest.dto.member.role.MemberRoleRequest;
import ru.bruh.bandmanager.rest.dto.member.role.MemberRoleResponse;
import ru.bruh.bandmanager.rest.service.member.role.MemberRoleService;

@RestController
@RequestMapping("/member/role")
@AllArgsConstructor
public class MemberRoleController {

    private final MemberRoleService service;

    @PostMapping("/create")
    public ApiResponse<MemberRoleResponse> create(@RequestBody MemberRoleRequest request) {
        return ApiResponse.success(service.create(request));
    }
}
