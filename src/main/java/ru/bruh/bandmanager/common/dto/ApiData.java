package ru.bruh.bandmanager.common.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class ApiData<T> implements Serializable {
    private final List<T> content;

    public List<T> getContent() {
        return content == null ? Collections.emptyList() : content;
    }
}
