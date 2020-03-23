package com.codenation.java.women.errorcenter.controller;

import com.codenation.java.women.errorcenter.dto.ApplicationDTO;
import com.codenation.java.women.errorcenter.dto.LogDTO;
import com.codenation.java.women.errorcenter.dto.MessageDTO;
import com.codenation.java.women.errorcenter.entity.Log;
import com.codenation.java.women.errorcenter.entity.User;
import com.codenation.java.women.errorcenter.exception.LogNotFoundException;
import com.codenation.java.women.errorcenter.service.interfaces.LogServiceInterface;
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
class LogController {
    private final LogServiceInterface logServiceInterface;

    public LogController(LogServiceInterface logServiceInterface) {
        this.logServiceInterface = logServiceInterface;
    }

    @ApiOperation(value = "Lista todos os logs encontrados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Logs encontrados")
    })
    @GetMapping("/api/v1/logs")
    List<Log> getLog() {
        return logServiceInterface.get();
    }

    @ApiOperation(value = "Retorna uma log pelo seu id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Log encontrado", response = LogDTO.class),
            @ApiResponse(code = 404, message = "Log não encontrado", response = MessageDTO.class)
    })
    @GetMapping("/api/v1/logs/{id}")
    ResponseEntity<Log> one(@PathVariable Long id) {
        return logServiceInterface.get(id)
                .map(log -> ResponseEntity.ok().body(log))
                .orElseThrow(() -> new LogNotFoundException(id));
    }

    @ApiOperation(value = "Adiciona um log")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Log criado com sucesso", response = LogDTO.class),
            @ApiResponse(code = 404, message = "Log não encontrada", response = MessageDTO.class)
    })
    @PostMapping("/api/v1/logs")
    Log newLog(@Valid @RequestBody LogDTO log) {
        return logServiceInterface.save(new ModelMapper().map(log, Log.class));
    }

    @ApiOperation(value = "Altera uma log")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Log criada com sucesso", response = LogDTO.class),
            @ApiResponse(code = 404, message = "Log não encontrada", response = MessageDTO.class)
    })
    @PutMapping("/api/v1/logs/{id}")
    User updateLog(@RequestBody ApplicationDTO updatedLog, @PathVariable Long id) {
        return logServiceInterface.update(new ModelMapper()
                .map(updatedLog, Log.class), id)
                .orElseThrow(() -> new LogNotFoundException(id));
    }

    @ApiOperation(value = "Remove uma log pelo seu id")
    @ApiResponses( {
            @ApiResponse(code = 204, message = "Log removida com sucesso"),
            @ApiResponse(code = 404, message = "Log não encontrada", response = MessageDTO.class)
    })
    @DeleteMapping("/api/v1/logs/{id}")
    void delete(@PathVariable Long id) {
        logServiceInterface.deleteByID(id);
    }



}
