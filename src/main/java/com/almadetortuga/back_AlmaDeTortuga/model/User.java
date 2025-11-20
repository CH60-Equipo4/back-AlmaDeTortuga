package com.almadetortuga.back_AlmaDeTortuga.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id_user;

    @Column(nullable = false, unique = true, length = 25)
    private String name;

    @Column(nullable = false, unique = true, length = 25)
    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 70)
    private String password;

    @Column(nullable = false, unique = true, columnDefinition = "DATETIME")
    private LocalDateTime registration;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private UserRol rol;

    public User() {
    }

    public User(Long id_user, String name, String last_name, String email, String password, LocalDateTime registration, UserRol rol) {
        this.id_user = id_user;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.registration = registration;
        this.rol = rol;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public LocalDateTime getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDateTime registration) {
        this.registration = registration;
    }

    public UserRol getRol() {
        return rol;
    }

    public void setRol(UserRol rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(id_user, user.id_user) && Objects.equals(name, user.name) && Objects.equals(last_name, user.last_name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(registration, user.registration) && rol == user.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_user, name, last_name, email, password, registration, rol);
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registration=" + registration +
                ", rol=" + rol +
                '}';
    }
}
