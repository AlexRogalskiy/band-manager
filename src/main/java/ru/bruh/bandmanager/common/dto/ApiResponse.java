package ru.bruh.bandmanager.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {

    public static final ApiResponse<Void> EMPTY = new ApiResponse<>(null, null);

    private transient T data;
    private ApiError error;

    public static ApiResponse<Void> error(ApiResponseCode apiResponseCode, Object... params) {
        return new ApiResponse<>(null, new ApiError(apiResponseCode.getCode(), apiResponseCode.getDescription(params)));
    }

    public static ApiResponse<Void> error(ApiResponseCode apiResponseCode, Throwable throwable, Object... params) {
        return new ApiResponse<>(null, new ApiError(apiResponseCode.getCode(), apiResponseCode.getDescription(params), ExceptionUtils.getStackTrace(throwable)));
    }

    public static ApiResponse<Void> error(ApiResponseCode apiResponseCode, String serverMessage, Object... params) {
        return new ApiResponse<>(null, new ApiError(apiResponseCode.getCode(), apiResponseCode.getDescription(params), serverMessage));
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, null);
    }

    public static ApiResponse<Void> error(ApiError error) {
        return new ApiResponse<>(null, error);
    }
}
