package com.appsdeveloperblog.reactive.ws.users.presentation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {

    @NotBlank(message = "First Name Can not be empty")
    @Size(min = 2, max = 50, message = "First name size should be between 2 and 50")
    private String firstName;

    @NotBlank(message = "Last Name Can not be empty")
    @Size(min = 2, max = 50, message = "Last name size should be between 2 and 50")
    private String lastName;

    @NotBlank(message = "Email Can not be empty")
    @Email
    private String email;

    @NotBlank(message = "Password Can not be empty")
    @Size(min = 2, max = 10, message = "Password size should be between 2 and 10")
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
