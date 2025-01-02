package com.sangura.spring_security.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Users {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Nonnull
    private String username;

    @Nonnull
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nonnull
    public String getUsername() {
        return username;
    }

    @Nonnull
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nonnull String password) {
        this.password = password;
    }

    public void setUsername(@Nonnull String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
