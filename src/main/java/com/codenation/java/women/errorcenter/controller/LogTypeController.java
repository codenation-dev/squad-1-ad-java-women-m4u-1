package com.codenation.java.women.errorcenter.controller;


import com.codenation.java.women.errorcenter.dto.LogTypeDTO;
import com.codenation.java.women.errorcenter.dto.MessageDTO;
import com.codenation.java.women.errorcenter.entity.LogType;
import com.codenation.java.women.errorcenter.exception.LogTypeNotFoundException;
import com.codenation.java.women.errorcenter.service.interfaces.LogTypeServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class LogTypeController {
    @RestController
    class LogTypeTypeController {
        private final LogTypeServiceInterface logTypeServiceInterface;

        public LogTypeTypeController(LogTypeServiceInterface logTypeServiceInterface) {
            this.logTypeServiceInterface = logTypeServiceInterface;
        }

        @ApiOperation(value = "Lista todas as logTypes cadastradas")
        @ApiResponses({
                @ApiResponse(code = 200, message = "LogTypeTypes encontradas")
        })
        @GetMapping("/api/v1/logTypes")
        List<LogType> getLogType() {
            return logTypeServiceInterface.get();
        }

        @ApiOperation(value = "Retorna um logType pelo seu id")
        @ApiResponses({
                @ApiResponse(code = 200, message = "LogType encontrada", response = LogTypeDTO.class),
                @ApiResponse(code = 404, message = "LogType não encontrada", response = MessageDTO.class)
        })
        @GetMapping("/api/v1/logTypes/{id}")
        ResponseEntity<LogType> one(@PathVariable Long id) {
            return logTypeServiceInterface.get(id)
                    .map(log -> ResponseEntity.ok().body(log))
                    .orElseThrow(() -> new LogTypeNotFoundException(id));
        }

        @ApiOperation(value = "Adiciona um log")
        @ResponseStatus(code = HttpStatus.CREATED)
        @ApiResponses({
                @ApiResponse(code = 201, message = "LogType criado com sucesso", response = LogTypeDTO.class),
                @ApiResponse(code = 404, message = "LogType não encontrado", response = MessageDTO.class)
        })
        @PostMapping("/api/v1/logTypes")
        LogType newLogType(@Valid @RequestBody LogTypeDTO log) {
            return logTypeServiceInterface.save(new ModelMapper().map(log, LogType.class));
        }

        @ApiOperation(value = "Altera uma logType")
        @ApiResponses({
                @ApiResponse(code = 200, message = "LogType criada com sucesso", response = LogTypeDTO.class),
                @ApiResponse(code = 404, message = "LogType não encontrada", response = MessageDTO.class)
        })
        @PutMapping("/api/v1/logTypes/{id}")
        LogType updateLogType(@RequestBody LogTypeDTO logTypeAlterada, @PathVariable Long id) {
            return logTypeServiceInterface.update(new ModelMapper()
                    .map(logTypeAlterada, LogType.class), id)
                    .orElseThrow(() -> new LogTypeNotFoundException(id));
        }

        @ApiOperation(value = "Remove uma log pelo seu id")
        @ApiResponses({
                @ApiResponse(code = 204, message = "LogType removido com sucesso"),
                @ApiResponse(code = 404, message = "LogType não encontrado", response = MessageDTO.class)
        })
        @DeleteMapping("/api/v1/logTypes/{id}")
        void delete(@PathVariable Long id) {
            logTypeServiceInterface.deleteByID(id);
        }
    }
}