package com.jordansoares.entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(uniqueConstraints = @UniqueConstraint(name = "uniqueEmail", columnNames = {"email"}))
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotNull
    @Column(name="firstname")
    private String firstname;
    @NotNull
    @Column(name="lastname")
    private String lastname;
    @NotNull
    @Column(name="password")
    private String password;

    @NotNull
    @Column(name="email", unique = true)
    private String email;

    @NotNull
    @Column(name="birthdate")
    @DateTimeFormat(pattern = "yyyy:mm:dd")
    private LocalDate birthdate;

    @NotNull
    @Column(name="lastKnownPresence")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalDateTime lastKnownPresence;

    public User() {
    }

    public User(String firstname, String lastname, String password, String email, LocalDate birthdate, LocalDateTime lastKnownPresence) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.lastKnownPresence = lastKnownPresence;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", lastKnownPresence=" + lastKnownPresence +
                '}';
    }
}
