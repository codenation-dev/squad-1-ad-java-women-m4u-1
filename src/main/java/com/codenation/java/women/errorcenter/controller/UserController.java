package com.codenation.java.women.errorcenter.controller;

import com.codenation.java.women.errorcenter.entity.User;
import com.codenation.java.women.errorcenter.service.interfaces.UserServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
