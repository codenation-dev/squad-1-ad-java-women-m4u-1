package com.codenation.java.women.errorcenter.controller;

import com.codenation.java.women.errorcenter.dto.MessageDTO;
import com.codenation.java.women.errorcenter.dto.UserDTO;
import com.codenation.java.women.errorcenter.entity.User;
import com.codenation.java.women.errorcenter.service.interfaces.UserServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {

    private final UserServiceInterface userServiceInterface;

    public LoginController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @ApiOperation(value = "Adiciona um usuário")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Usuário criado com sucesso", response = UserDTO.class),
            @ApiResponse(code = 404, message = "Usuário não encontrado", response = MessageDTO.class)
    })
    @PostMapping("/errorcenter/signup")
    User newUser(UserDTO user) {
        return userServiceInterface.save(new ModelMapper().map(user, User.class));
    }
}