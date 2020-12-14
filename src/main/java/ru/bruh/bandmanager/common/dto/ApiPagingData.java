package ru.bruh.bandmanager.common.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ApiPagingData<T> extends ApiData<T> {

    private final int pageSize;
    private final int pageNumber;
    private final long totalElements;
    private final int totalPages;

    public ApiPagingData(List<T> content, int pageSize, int pageNumber, long totalElements, int totalPages) {
        super(content);
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
}
