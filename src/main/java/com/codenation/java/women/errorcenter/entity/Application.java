package com.codenation.java.women.errorcenter.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "applications")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

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
    private List<User> users;

    @OneToMany
    private List<Log> logs;
}
