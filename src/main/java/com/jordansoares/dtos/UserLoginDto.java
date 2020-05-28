package com.jordansoares.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class UserLoginDto {

    @NotNull
    @Size(min = 3, max = 512)
    private String password;

    @NotNull
    @Email
    @Size(min = 3, max = 254)
    private String email;

    private LocalDateTime lastKnownPresence;

    public UserLoginDto() {
    }

    public UserLoginDto(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLastKnownPresence() {
        return lastKnownPresence;
    }

    public void setLastKnownPresence(LocalDateTime lastKnownPresence) {
        this.lastKnownPresence = lastKnownPresence;
    }
}
