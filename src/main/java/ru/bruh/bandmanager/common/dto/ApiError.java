package ru.bruh.bandmanager.common.dto;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Getter
public class ApiError implements Serializable {
    private int code;
    private String description;
    private String serverMessage;
    private transient Object data;

    public ApiError() {
    }

    public ApiError(int code, String description, String serverMessage) {
        this.code = code;
        this.description = description;
        this.serverMessage = StringUtils.substring(serverMessage, 0, 2000);
    }

    public ApiError(int code, String description, String serverMessage, Object data) {
        this.code = code;
        this.description = description;
        this.serverMessage = StringUtils.substring(serverMessage, 0, 2000);
        this.data = data;
    }

    public ApiError(int code, String description) {
        this.code = code;
        this.description = description;
        this.serverMessage = null;
    }
}

