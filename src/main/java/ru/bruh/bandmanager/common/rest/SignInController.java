package ru.bruh.bandmanager.common.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.common.rest.dto.SignInRequest;
import ru.bruh.bandmanager.common.security.service.UserEntityService;

@RestController
@RequestMapping("/sign-in")
@RequiredArgsConstructor
public class SignInController {
    private final UserEntityService userEntityService;

    @PostMapping
    public ApiResponse<Integer> signIn(@RequestBody SignInRequest request) {
        return ApiResponse.success(userEntityService.signInUser(request));
    }
}
