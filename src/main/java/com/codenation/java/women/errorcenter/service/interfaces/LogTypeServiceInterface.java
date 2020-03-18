package com.codenation.java.women.errorcenter.service.interfaces;

import com.codenation.java.women.errorcenter.dto.LogTypeDTO;

import java.util.List;
import java.util.Optional;

public interface LogTypeServiceInterface {

    List<LogTypeDTO> findAll();

    Optional<LogTypeDTO> findById(Long id);

    Optional<LogTypeDTO> save(LogTypeDTO logType);

    Optional<LogTypeDTO> update(LogTypeDTO logType, Long id);

    void deleteByID(Long id);
}
