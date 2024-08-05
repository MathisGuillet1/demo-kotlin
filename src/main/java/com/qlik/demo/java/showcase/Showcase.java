package com.qlik.demo.java.showcase;

import java.util.Map;
import java.util.Optional;

// Just showcasing stuff
public class Showcase {

    private static final Map<String, User> usersById = Map.of(
            "8ab755ba-3db8-4715-bf4e-0627928c2586",
            new User("Mathis", "mathis@fake.com"),
            "d9163211-4d79-45c4-8ad9-bb35916db86d",
            new User("John", "john@fake.com")
    );

    public void sendEmailToUser(String userId) {
        final var userEmail = Optional.ofNullable(usersById.get(userId))
                .map(User::email)
                .orElseThrow(() -> new IllegalStateException("User with id " + userId + " was not found"));

        if (userEmail != null && !userEmail.isEmpty()) {
            // Do something with user email...
            System.out.println(userEmail);
        }
    }
}

record User(String name, String email) {
}
