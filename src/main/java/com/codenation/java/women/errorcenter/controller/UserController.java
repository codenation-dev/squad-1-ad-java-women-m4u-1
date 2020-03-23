package com.codenation.java.women.errorcenter.controller;
import com.codenation.java.women.errorcenter.dto.MessageDTO;
import com.codenation.java.women.errorcenter.dto.UserDTO;
import com.codenation.java.women.errorcenter.entity.User;
import com.codenation.java.women.errorcenter.exception.ApplicationNotFoundException;
import com.codenation.java.women.errorcenter.exception.UserNotFoundException;
import com.codenation.java.women.errorcenter.service.interfaces.UserServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping("api/v1//users")
    List<User> getUser() {
        return userServiceInterface.get();
    }

    @ApiOperation(value = "Retorna uma usuário pelo seu id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário encontrado", response = UserDTO.class),
            @ApiResponse(code = 404, message = "Usuário não encontrado", response = MessageDTO.class)
    })
    @GetMapping("/api/v1/users/{id}")
    ResponseEntity<User> one(@PathVariable Long id) {
        return userServiceInterface.get(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElseThrow(() -> new ApplicationNotFoundException(id));
    }

    @ApiOperation(value = "Adiciona um usuário")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Aplicação criada com sucesso", response = UserDTO.class),
            @ApiResponse(code = 404, message = "Aplicação não encontrada", response = MessageDTO.class)
    })
    @PostMapping("/api/v1/users")
    User newUser(@Valid @RequestBody UserDTO application) {
        return userServiceInterface.save(new ModelMapper().map(application, User.class));
    }

    @ApiOperation(value = "Altera um usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuaário criado com sucesso", response = UserDTO.class),
            @ApiResponse(code = 404, message = "Usuaário não encontrado", response = MessageDTO.class)
    })
    @PutMapping("/api/api/users/{id}")
    User updateUser(@RequestBody UserDTO updatedUser, @PathVariable Long id) {
        return userServiceInterface.update(new ModelMapper()
                .map(updatedUser, User.class), id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @ApiOperation(value = "Remove uma usuaário pelo seu id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Usuário removido com sucesso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado", response = MessageDTO.class)
    })
    @DeleteMapping("/api/v1/users/{id}")
    void delete(@PathVariable Long id) {
        userServiceInterface.deleteByID(id);
    }
}

