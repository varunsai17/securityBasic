package com.example.springsecuritystarter.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

@Entity
@Table(name="User")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    private String email;

    private String userId;

    private String password;

    private String role;


    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
