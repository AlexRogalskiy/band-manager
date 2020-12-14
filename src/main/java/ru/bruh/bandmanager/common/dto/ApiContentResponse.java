package ru.bruh.bandmanager.common.dto;

import lombok.Getter;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Getter
public class ApiContentResponse<T> implements Serializable {

    private ApiData<T> data;
    private ApiError error;

    public ApiContentResponse() {
    }

    protected ApiContentResponse(Collection<T> data, ApiError error) {
        this.data = new ApiData<>(new ArrayList<>(data));
        this.error = error;
    }

    protected ApiContentResponse(Collection<T> data, ApiError error, int pageSize, int pageNumber, long totalElements, int totalPages) {
        this.data = new ApiPagingData<>(new ArrayList<>(data), pageSize, pageNumber, totalElements, totalPages);
        this.error = error;
    }

    public static <T> ApiContentResponse<T> error(ApiResponseCode apiResponseCode, Collection<T> data, Throwable throwable, Object... params) {
        return new ApiContentResponse<>(data, new ApiError(apiResponseCode.getCode(), apiResponseCode.getDescription(params), ExceptionUtils.getStackTrace(throwable)));
    }

    public static <T> ApiContentResponse<T> success(Collection<T> data) {
        return new ApiContentResponse<>(data, null);
    }

    public static <T> ApiContentResponse<T> success(Collection<T> data, int pageSize, int pageNumber, long totalElements, int totalPages) {
        return new ApiContentResponse<>(data, null, pageSize, pageNumber, totalElements, totalPages);
    }
}
