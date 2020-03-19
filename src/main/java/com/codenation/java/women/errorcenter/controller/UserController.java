package com.codenation.java.women.errorcenter.controller;

import com.codenation.java.women.errorcenter.dto.MessageDTO;
import com.codenation.java.women.errorcenter.dto.UserDTO;
import com.codenation.java.women.errorcenter.entity.User;
import com.codenation.java.women.errorcenter.service.interfaces.UserServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
