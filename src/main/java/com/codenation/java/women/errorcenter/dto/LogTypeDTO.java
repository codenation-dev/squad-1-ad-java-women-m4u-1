package com.codenation.java.women.errorcenter.dto;

import com.codenation.java.women.errorcenter.entity.LogType;
import com.codenation.java.women.errorcenter.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
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
}
