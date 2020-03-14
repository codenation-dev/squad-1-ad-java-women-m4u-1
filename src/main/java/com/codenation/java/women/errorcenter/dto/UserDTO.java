package com.codenation.java.women.errorcenter.dto;

import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.entity.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {

    private Long user_id;

    @NotNull(message = "Um nome deve ser informado.")
    private String name;

    private String token;

    @NotNull(message = "Um e-mail deve ser informado.")
    private String email;

    @NotNull(message = "Uma senha deve ser informada.")
    private String password;

    private LocalDateTime createdAt;

    private List<Application> applications;

    public UserDTO(){
    }

    public UserDTO(User user) {
        this.user_id = user_id;
        this.name = name;
        this.token = token;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.applications = applications;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
