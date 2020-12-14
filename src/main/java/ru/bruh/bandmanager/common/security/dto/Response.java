package ru.bruh.bandmanager.common.security.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Response {

    private String message;
}