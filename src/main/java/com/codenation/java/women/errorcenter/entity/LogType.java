package com.codenation.java.women.errorcenter.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "logType")
@Data
public class LogType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 80)
    private String title;

    @Column
    @Size(max = 50)
    private String error_level;

    @Column
    @Size(max = 200)
    private String description;

    @OneToMany(mappedBy = "logType", cascade = CascadeType.ALL)
    private List<Log> logs;
}
