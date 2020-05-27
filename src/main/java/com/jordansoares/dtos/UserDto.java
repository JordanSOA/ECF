package com.jordansoares.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private LocalDate birthdate;
    private LocalDateTime lastKnownPresence;

    public UserDto() {
    }

    public UserDto(String firstname, String lastname, String password, String email, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDateTime getLastKnownPresence() {
        return lastKnownPresence;
    }

    public void setLastKnownPresence(LocalDateTime lastKnownPresence) {
        this.lastKnownPresence = lastKnownPresence;
    }
}
