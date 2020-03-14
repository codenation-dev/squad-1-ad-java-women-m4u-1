package com.codenation.java.women.errorcenter.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "logtype")
public class LogType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id")
    private User log_id;

    @Column
    @Size(max = 80)
    private String title;

    @Column
    @Size(max = 50)
    private String error_level;

    @Column
    @Size(max = 200)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogType logType = (LogType) o;
        return Objects.equals(id, logType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
