package ru.bruh.bandmanager.common.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.common.rest.dto.SignInRequest;
import ru.bruh.bandmanager.common.rest.mapper.UserEntityMapper;
import ru.bruh.bandmanager.common.security.repository.UserEntityRepository;

@Service
@RequiredArgsConstructor
public class UserEntityService {
    private final UserEntityRepository repository;
    private final UserEntityMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public Integer signInUser(SignInRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        return repository.save(mapper.toUserEntity(request)).getId();
    }
}
