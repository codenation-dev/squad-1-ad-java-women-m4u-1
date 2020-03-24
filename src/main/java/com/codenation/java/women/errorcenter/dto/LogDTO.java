package com.codenation.java.women.errorcenter.dto;

import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.entity.Log;
import com.codenation.java.women.errorcenter.entity.LogType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter @Setter
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
}
