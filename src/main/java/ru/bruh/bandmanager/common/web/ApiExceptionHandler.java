package ru.bruh.bandmanager.common.web;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.bruh.bandmanager.common.dto.ApiResponse;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Void>> handleAccessDeniedException(AccessDeniedException ex) {
        String message = ex.getMessage();
        log.error(message, ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                             .body(ApiResponse.error(ApiResponseCode.ACCESS_DENIED, ex));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleExceptions(Exception ex) {
        String message = ex.getMessage();
        log.error(message, ex);
        HttpStatus status = ex instanceof IllegalArgumentException ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status)
                             .body(ApiResponse.error(ApiResponseCode.INTERNAL_SERVER_ERROR, ex));
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessExceptions(BusinessException e) {
        String message = e.getMessage();
        log.error("Business exception occurred on the server. Message: {}", message);
        log.error(e.getMessage(), e);
        HttpStatus httpStatus = e.getHttpStatus();
        return ResponseEntity.status(httpStatus != null ? httpStatus : HttpStatus.OK)
                             .body(ApiResponse.error(e.getApiResponseCode(), e, e.getParams()));
    }
}
