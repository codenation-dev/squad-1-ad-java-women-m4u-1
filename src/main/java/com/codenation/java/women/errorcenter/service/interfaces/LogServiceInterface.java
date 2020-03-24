package com.codenation.java.women.errorcenter.service.interfaces;

import com.codenation.java.women.errorcenter.entity.Log;
import com.codenation.java.women.errorcenter.entity.User;

import java.util.List;
import java.util.Optional;

public interface LogServiceInterface {
    List<Log> get();
    Optional<Log> get(Long id);
    Log save(Log log);
    Optional<Log> update(Log log, Long id);
    void deleteByID(Long id);
}
