package com.codenation.java.women.errorcenter.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "logTypes")
public class LogType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 80)/errorcenter/
/errorcenter/
/errorcenter/
    private String title;

    @Column
    @Size(max = 50)
    private String error_level;

    @Column
    @Size(max = 200)
    private String description;

    @OneToMany(mappedBy = "logType", cascade = CascadeType.ALL)
    private List<Log> logs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getError_level() {
        return error_level;
    }

    public void setError_level(String error_level) {
        this.error_level = error_level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

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
