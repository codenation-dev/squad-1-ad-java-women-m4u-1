package com.codenation.java.women.errorcenter.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    @Size(max = 150)
    private String name;

    @Column
    @Size(max = 100)
    private String token;

    @Column
    @Email
    @Size(max = 80)
    private String email;

    @Column
    @Size(max = 255)
    private String password;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToMany
    private List<Application> applications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user_id, user.user_id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(token, user.token) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(applications, user.applications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, name, token, email, password, createdAt, applications);
    }
}
