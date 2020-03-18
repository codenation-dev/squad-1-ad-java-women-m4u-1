package com.codenation.java.women.errorcenter.controller;

import com.codenation.java.women.errorcenter.dto.MessageDTO;
import com.codenation.java.women.errorcenter.dto.UserDTO;
import com.codenation.java.women.errorcenter.entity.User;
import com.codenation.java.women.errorcenter.service.interfaces.UserServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private final UserServiceInterface userServiceInterface;

    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @ApiOperation(value = "Lista todos os usuários")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuários encontrados")
    })
    @GetMapping("errorcenter/users")
    List<User> getUser() {
        return userServiceInterface.get();
    }

    @ApiOperation(value = "Retorna um usuário pelo seu id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário encontrado", response = UserDTO.class),
            @ApiResponse(code= 404, message = "Usuário não encontrado", response = MessageDTO.class)
    })
    @GetMapping("errorcenter/users{id}")
    ResponseEntity<User> one(@PathVariable Long id) {
        return userServiceInterface.get(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseThrow(() ->{ throw new umaExceptionAqui(id);});
    }

    @ApiOperation(value = "Adiciona um usuário")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 201, message ="Usuário criado com sucesso", response = UserDTO.class),
            @ApiResponse(code = 404, message = "Usuário não encontrado", response = MessageDTO.class)
        })
    @PostMapping("/errorcenter/users")
    User newUser(@Valid @RequestBody UserDTO user) {
        return userServiceInterface.save(new ModelMapper().map(user, User.class));
    }

    @ApiOperation(value = "Altera um usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message="Usuário atualizado com sucesso", response = UserDTO.class),
            @ApiResponse(code = 404, message= "Usuário não encontrado", response = MessageDTO.class)
    })
    @PutMapping("/errorcenter/{id}")
    User updateUser(@RequestBody UserDTO updatedUser, @PathVariable Long id) {
        return userServiceInterface.update(new ModelMapper()
                .map(updatedUser, User.class), id)
                .orElseThrow(() -> { throw new ExeptionAqui(id);});
    }
}
