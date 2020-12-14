package ru.bruh.bandmanager.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;
import ru.bruh.bandmanager.common.security.dto.Response;

@RestController
@RequestMapping("/band")
@AllArgsConstructor
public class BandController {

    @GetMapping("/string")
    public ApiResponse<String> string() {
        return ApiResponse.success("Ey");
    }

    @GetMapping("/object")
    public ApiResponse<Response> object() {
        return ApiResponse.success(new Response().setMessage("Ey"));
    }

    @GetMapping("business-exception")
    public ApiResponse<String> businessException() {
        throw new BusinessException(ApiResponseCode.BAD_CREDENTIALS);
    }

    @GetMapping("exception")
    public ApiResponse<String> exception() {
        throw new NullPointerException();
    }
}
