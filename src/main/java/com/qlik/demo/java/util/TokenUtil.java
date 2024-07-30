package com.qlik.demo.java.util;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public final class TokenUtil {

    // Dot not allow instantiation
    private TokenUtil() {
    }

    public static Optional<UUID> extractUserId() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            final var principal = authentication.getPrincipal();

            if (principal instanceof AuthUserDetails userDetails) {
                final var userId = userDetails.id();
                return Optional.ofNullable(userId)
                        .map(UUID::fromString);
            }
        }
        return Optional.empty();
    }
}
