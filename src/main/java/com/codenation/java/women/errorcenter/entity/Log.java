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

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Application appId;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Application getAppId() {
        return appId;
    }

    public void setAppId(Application appId) {
        this.appId = appId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<LogType> getLogTypes() {
        return logTypes;
    }

    public void setLogTypes(List<LogType> logTypes) {
        this.logTypes = logTypes;
    }

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
