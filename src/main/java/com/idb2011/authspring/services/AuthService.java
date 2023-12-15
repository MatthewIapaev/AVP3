package com.idb2011.authspring.services;

import com.idb2011.authspring.db.query.UserQuery;
import com.idb2011.authspring.dto.CreateUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserQuery userQuery;

    public void registerUser(CreateUserDTO createUserDTO) {
        if (!createUserDTO.password1().equals(createUserDTO.password2())){
            throw new InvalidParameterException("Пароли не совпадают");
        }
        userQuery.createUser(createUserDTO.username(), createUserDTO.password1());
    }
}
