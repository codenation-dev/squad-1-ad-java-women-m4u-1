package com.codenation.java.women.errorcenter.dto;

import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.entity.Log;
import com.codenation.java.women.errorcenter.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class ApplicationDTO {

    private Long id;

    @NotNull(message= "Um id de usuário deve ser informado.")
    private User userId;

    @NotNull(message = "Um nome para a aplicação deve ser informado.")
    private String appName;

    @NotNull(message = "Uma descrição para a aplicação deve ser informada.")
    private String description;

    private LocalDateTime createdAt;
    private List<User> users;
    private List<Log> logs;

    public ApplicationDTO(){
    }

    public ApplicationDTO(Application application) {
        this.id = id;
        this.userId = userId;
        this.appName = appName;
        this.description = description;
        this.createdAt = createdAt;
        this.users = users;
        this.logs = logs;
    }
}
