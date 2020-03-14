package com.codenation.java.women.errorcenter.dto;

import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.entity.Log;
import com.codenation.java.women.errorcenter.entity.User;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class ApplicationDTO {

    private Long id;
    private User user_id;

    @NotNull(message = "Um nome para a aplicação deve ser informado.")
    private String app_name;

    @NotNull(message = "Uma descrição para a aplicação deve ser informada.")
    private String description;

    private LocalDateTime createdAt;
    private List<User> users;
    private List<Log> logs;

    public ApplicationDTO(Application application) {
        this.id = id;
        this.user_id = user_id;
        this.app_name = app_name;
        this.description = description;
        this.createdAt = createdAt;
        this.users = users;
        this.logs = logs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
