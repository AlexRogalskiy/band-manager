package ru.bruh.bandmanager.common.exception;

import org.springframework.http.HttpStatus;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;

public class BusinessException extends RuntimeException {

    private final ApiResponseCode apiResponseCode;
    private final HttpStatus httpStatus;
    private final transient Object[] params;
    private final transient Object data;

    public BusinessException(ApiResponseCode apiResponseCode, HttpStatus httpStatus, Object... params) {
        super(apiResponseCode.getDescription());
        this.apiResponseCode = apiResponseCode;
        this.httpStatus = httpStatus;
        this.data = null;
        this.params = params;
    }

    public BusinessException(ApiResponseCode apiResponseCode, Object data, HttpStatus httpStatus, Object... params) {
        super(apiResponseCode.getDescription());
        this.apiResponseCode = apiResponseCode;
        this.httpStatus = httpStatus;
        this.params = params;
        this.data = data;
    }

    public BusinessException(ApiResponseCode apiResponseCode, HttpStatus httpStatus, String description, Object... params) {
        super(apiResponseCode.getDescription() + description);
        this.apiResponseCode = apiResponseCode;
        this.httpStatus = httpStatus;
        this.params = params;
        this.data = null;
    }

    public BusinessException(Throwable cause, ApiResponseCode apiResponseCode, HttpStatus httpStatus, Object... params) {
        super(apiResponseCode.getDescription(), cause);
        this.apiResponseCode = apiResponseCode;
        this.httpStatus = httpStatus;
        this.params = params;
        this.data = null;
    }

    public BusinessException(ApiResponseCode apiResponseCode, Object... params) {
        super(apiResponseCode.getDescription());
        this.apiResponseCode = apiResponseCode;
        this.params = params;
        this.httpStatus = null;
        this.data = null;
    }

    public BusinessException(Throwable cause, ApiResponseCode apiResponseCode, Object... params) {
        super(apiResponseCode.getDescription(), cause);
        this.apiResponseCode = apiResponseCode;
        this.params = params;
        this.httpStatus = null;
        this.data = null;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ApiResponseCode getApiResponseCode() {
        return apiResponseCode;
    }

    public Object[] getParams() {
        return params;
    }

    public Object getData() {
        return data;
    }
}
