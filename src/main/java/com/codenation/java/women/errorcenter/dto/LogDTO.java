package com.codenation.java.women.errorcenter.dto;

import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.entity.Log;
import com.codenation.java.women.errorcenter.entity.LogType;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class LogDTO {

    private Long id;
    private Application app_id;

    @NotNull(message = "Uma data para o log deve ser informada.")
    private Date date;

    @NotNull(message = "Um ambiente para o log deve ser informado.")
    private String enviroment;

    private LocalDateTime createdAt;
    private List<LogType> logTypes;

    public LogDTO(Log log) {
        this.id = id;
        this.app_id = app_id;
        this.date = date;
        this.enviroment = enviroment;
        this.createdAt = createdAt;
        this.logTypes = logTypes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Application getApp_id() {
        return app_id;
    }

    public void setApp_id(Application app_id) {
        this.app_id = app_id;
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
}
