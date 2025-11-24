package com.almadetortuga.back_AlmaDeTortuga.model;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id_user;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 25)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 70)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRol rol;

    public User() {
    }

    public User(Long id_user, String name, String lastname, String email, String password, UserRol rol) {
        this.id_user = id_user;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
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

    public String getLastname() {
        return lastname;
    }

    public void setLast_name(String lastname) {
        this.lastname = lastname;
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

    public UserRol getRol() {
        return rol;
    }

    public void setRol(UserRol rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(id_user, user.id_user) && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email) && Objects.equals(password, user.password)  && rol == user.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_user, name, lastname, email, password, rol);
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", name='" + name + '\'' +
                ", last_name='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
