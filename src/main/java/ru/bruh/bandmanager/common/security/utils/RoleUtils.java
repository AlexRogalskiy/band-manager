package ru.bruh.bandmanager.common.security.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.bruh.bandmanager.common.dto.ApiResponseCode;
import ru.bruh.bandmanager.common.exception.BusinessException;
import ru.bruh.bandmanager.common.security.model.UserEntity;

public class RoleUtils {

    private static final String ADMIN_ROLE = "ADMIN";
    private static final String MANAGER_ROLE = "MANAGER";

    private RoleUtils() {

    }

    public static void validateCurrentUserAdmin() {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .noneMatch(r -> r.getAuthority().equals(ADMIN_ROLE))) {
            throw new BusinessException(ApiResponseCode.INSUFFICIENT_RIGHTS);
        }
    }

    public static GrantedAuthority getUserRole(UserEntity user) {
        if (user.getUsername().equals("admin")) {
            return new SimpleGrantedAuthority(ADMIN_ROLE);
        }
        return new SimpleGrantedAuthority(MANAGER_ROLE);
    }
}
