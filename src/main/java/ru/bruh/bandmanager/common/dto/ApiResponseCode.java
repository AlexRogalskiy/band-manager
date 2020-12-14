package ru.bruh.bandmanager.common.dto;

import java.io.Serializable;

public enum ApiResponseCode implements Serializable {
    BAD_CREDENTIALS(1, "Неверное имя пользователя или пароль"),
    TOKEN_EXPIRED(2, "Время жизни токена окончено"),
    INVALID_TOKEN(3, "Невалидный токен"),
    INVALID_TOKEN_SIGNATURE(4, "Невалидная подпись токена"),
    INVALID_TOKEN_DATA(5, "Невалидные данные в токене"),
    ACCESS_DENIED(6, "Доступ запрещен"),
    INTERNAL_SERVER_ERROR(7, "Неизвестная ошибка сервера"),
    NOT_FOUND(8, "Запрашиваемый ресурс не найден"),
    METHOD_NOT_ALLOWED(9, "неверный HTTP метод");

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
