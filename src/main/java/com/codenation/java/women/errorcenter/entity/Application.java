package com.codenation.java.women.errorcenter.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    private User user_id;

    @Column
    @Size(max = 50)
    private String app_name;

    @Column
    @Size(max = 200)
    private String description;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToMany
    private List<User> users;

    @OneToMany
    private List<Log> logs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user_id, that.user_id) &&
                Objects.equals(app_name, that.app_name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(users, that.users) &&
                Objects.equals(logs, that.logs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, app_name, description, createdAt, users, logs);
    }
}
