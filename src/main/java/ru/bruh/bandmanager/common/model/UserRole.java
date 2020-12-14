package ru.bruh.bandmanager.common.model;

import lombok.Getter;

@Getter
public enum UserRole {

    ROLE_ADMIN("Администратор"),
    ROLE_USER("Участник");

    private final String code;
    private final String title;

    UserRole(String title) {
        this.code = this.name();
        this.title = title;
    }

}
