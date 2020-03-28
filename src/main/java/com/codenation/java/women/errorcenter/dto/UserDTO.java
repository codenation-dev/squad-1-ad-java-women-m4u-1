package com.codenation.java.women.errorcenter.dto;

import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class UserDTO {

    private Long userId;

    @NotNull(message = "Um usuario deve ser informado.")
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
        this.userId = userId;
        this.name = name;
        this.token = token;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.applications = applications;
    }
}
