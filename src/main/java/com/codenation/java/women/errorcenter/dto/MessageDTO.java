package com.codenation.java.women.errorcenter.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Mensagem", description = "Mensagem contendo a descrição do erro")
@Getter @Setter
public class MessageDTO {

    @ApiModelProperty(value = "Mensagem descritiva do erro", readOnly = true)
    private String mensagem;

    public MessageDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public MessageDTO(){}
}
