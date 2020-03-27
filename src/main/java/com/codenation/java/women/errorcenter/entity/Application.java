package com.codenation.java.women.errorcenter.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "users_applications",
            joinColumns = { @JoinColumn(name = "applications_id") },
            inverseJoinColumns = { @JoinColumn(name = "users_id") })
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "appId", cascade = CascadeType.ALL)
    private List<Log> logs;

    public Application() {
    }

    public Application( User userId, @Size(max = 50) String appName, @Size(max = 200) String description, LocalDateTime createdAt, Set<User> users, List<Log> logs) {
            this.userId = userId;
            this.appName = appName;
            this.description = description;
            this.createdAt = createdAt;
            this.users = users;
            this.logs = logs;
        }
}
