package com.qlik.demo.java.util;

import java.security.Principal;

public record AuthUserDetails(
        String id,
        String userName
) implements Principal {

    @Override
    public String getName() {
        return userName;
    }
}
