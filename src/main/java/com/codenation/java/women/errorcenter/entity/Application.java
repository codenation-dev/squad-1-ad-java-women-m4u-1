package com.codenation.java.women.errorcenter.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "applications")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 50)
    private String appName;

    @Column
    @Size(max = 200)
    private String description;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(name = "users_applications",
            joinColumns = { @JoinColumn(name = "application_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> users = new HashSet<>();

    @OneToMany
    private List<Log> logs;
}

