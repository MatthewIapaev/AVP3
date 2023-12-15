package com.idb2011.authspring.db.query;

import com.idb2011.jooq.tables.Users;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.idb2011.jooq.tables.Authorities.AUTHORITIES;
import static com.idb2011.jooq.tables.Users.USERS;

@Component
@RequiredArgsConstructor
public class UserQuery {
    private final DSLContext dsl;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(String username, String password) {
        dsl
                .insertInto(USERS)
                .set(USERS.USERNAME, username)
                .set(USERS.PASSWORD, passwordEncoder.encode(password))
                .execute();

        dsl
                .insertInto(AUTHORITIES)
                .set(AUTHORITIES.USERNAME, username)
                .set(AUTHORITIES.AUTHORITY, "USER")
                .execute();
    }


}
