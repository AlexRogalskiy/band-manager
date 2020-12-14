package ru.bruh.bandmanager.common.rest.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
