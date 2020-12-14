package ru.bruh.bandmanager.common.dto;

import java.io.Serializable;

public enum ApiResponseCode implements Serializable {
    BAD_CREDENTIALS(1, "Неверное имя пользователя или пароль"),
    ACCESS_DENIED(2, "Доступ запрещен"),
    INTERNAL_SERVER_ERROR(3, "Неизвестная ошибка сервера"),

    COUNTRY_NOT_FOUND(4, "Страна на найдена"),
    BAND_NOT_FOUND(5, "Группа не найдена"),
    MEMBER_ROLE_NOT_FOUND(6, "Амплуа не найдено"),
    MEMBER_NOT_FOUND(7, "Участник не найден");

    private final int code;
    private final String description;

    ApiResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription(Object... params) {
        if (params == null || params.length == 0) {
            return description;
        } else {
            return String.format(description, params);
        }
    }
}
