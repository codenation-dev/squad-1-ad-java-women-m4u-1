package com.codenation.java.women.errorcenter.service.interfaces;

import com.codenation.java.women.errorcenter.dto.LogDTO;

import java.util.List;
import java.util.Optional;

public interface LogServiceInterface {

    List<LogDTO> findAll();

    Optional<LogDTO> findById(Long id);

    Optional<LogDTO> save(LogDTO log);

    void deleteByID(Long id);
}
