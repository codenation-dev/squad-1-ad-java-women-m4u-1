package com.codenation.java.women.errorcenter.service.interfaces;

import com.codenation.java.women.errorcenter.dto.LogTypeDTO;
import com.codenation.java.women.errorcenter.entity.LogType;
import com.codenation.java.women.errorcenter.entity.User;

import java.util.List;
import java.util.Optional;

public interface LogTypeServiceInterface {

    List<LogType> get();
    Optional<LogType> get(Long id);
    LogType save(LogType logType);
    Optional<LogType> update(LogType logType, Long id);
    void deleteByID(Long id);
}
