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
}
