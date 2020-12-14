package ru.bruh.bandmanager.common.rest.mapper;

import org.mapstruct.Mapper;
import ru.bruh.bandmanager.common.rest.dto.SignInRequest;
import ru.bruh.bandmanager.common.security.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntity toUserEntity(SignInRequest request);
}
