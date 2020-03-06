package com.codenation.java.women.errorcenter.dto;

import com.codenation.java.women.errorcenter.entity.LogType;
import com.codenation.java.women.errorcenter.entity.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LogTypeDTO {

    private Long id;
    private User log_id;

    @NotNull(message = "Um título para o tipo de log deve ser informado.")
    private String title;

    @NotNull(message = "Um nível para o tipo de log deve ser informado.")
    private String error_level;

    @NotNull(message = "Uma descrição para o tipo de log deve ser informada.")
    private String description;

    public LogTypeDTO(LogType logType) {
        this.id = id;
        this.log_id = log_id;
        this.title = title;
        this.error_level = error_level;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getLog_id() {
        return log_id;
    }

    public void setLog_id(User log_id) {
        this.log_id = log_id;
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
}
