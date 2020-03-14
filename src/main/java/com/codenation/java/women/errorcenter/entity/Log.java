package com.codenation.java.women.errorcenter.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id")
    private Application app_id;

    @Column
    private Date date;

    @Column
    @Size(max = 50)
    private String enviroment;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany
    private List<LogType> logTypes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
