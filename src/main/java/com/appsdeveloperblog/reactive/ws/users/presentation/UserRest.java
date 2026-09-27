package com.appsdeveloperblog.reactive.ws.users.presentation;

import java.util.UUID;

public class UserRest {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;

    public UserRest() {
    }

    public UserRest(UUID uuid, String firstName, String lastName, String email) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

}
