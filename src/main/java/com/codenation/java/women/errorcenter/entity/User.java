package com.codenation.java.women.errorcenter.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    @NotNull
    @Size(max = 150)
    private String name;

    @Column
    @NotNull
    @Size(max = 100)
    private String token;

    @Column
    @Email
    @Size(max = 80)
    @NotNull
    private String email;

    @Column
    @NotNull
    @Size(max = 255)
    private String password;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToMany
    private List<Application> applications;
}
