package com.codenation.java.women.errorcenter.controller;


import com.codenation.java.women.errorcenter.dto.ApplicationDTO;
import com.codenation.java.women.errorcenter.dto.MessageDTO;
import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.exception.ApplicationNotFoundException;
import com.codenation.java.women.errorcenter.service.interfaces.ApplicationServiceInterface;
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
class ApplicationController {
    private final ApplicationServiceInterface applicationServiceInterface;

    public ApplicationController(ApplicationServiceInterface applicationServiceInterface) {
        this.applicationServiceInterface = applicationServiceInterface;
    }

    @ApiOperation(value = "Lista todas as aplicações cadastradas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Aplicações encontradas")
    })
    @GetMapping("/errorcenter/applications")
    List<Application> getApplication() {
        return applicationServiceInterface.get();
    }

    @ApiOperation(value = "Retorna uma apalicação pelo seu id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Aplicação encontrada", response = ApplicationDTO.class),
            @ApiResponse(code = 404, message = "Aplicação não encontrada", response = MessageDTO.class)
    })
    @GetMapping("/api/v1/pessoas/{id}")
    ResponseEntity<Application> one(@PathVariable Long id) {
        return applicationServiceInterface.get(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElseThrow(() -> new ApplicationNotFoundException(id));
    }

    @ApiOperation(value = "Adiciona uma aplicação")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Aplicação criada com sucesso", response = ApplicationDTO.class),
            @ApiResponse(code = 404, message = "Aplicação não encontrada", response = MessageDTO.class)
    })
    @PostMapping("/api/v1/pessoas")
    Application newApplication(@Valid @RequestBody ApplicationDTO application) {
        return applicationServiceInterface.save(new ModelMapper().map(application, Application.class));
    }

    @ApiOperation(value = "Altera uma aplicação")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Application criada com sucesso", response = ApplicationDTO.class),
            @ApiResponse(code = 404, message = "Application não encontrada", response = MessageDTO.class)
    })
    @PutMapping("/errorcenter/application/{id}")
    Application updateApplication(@RequestBody ApplicationDTO updatedApplication, @PathVariable Long id) {
        return applicationServiceInterface.update(new ModelMapper()
                .map(updatedApplication, Application.class), id)
                .orElseThrow(() -> { throw new ApplicationNotFoundException(id); });
    }
}
