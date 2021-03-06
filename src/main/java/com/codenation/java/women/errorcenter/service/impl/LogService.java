package com.codenation.java.women.errorcenter.service.impl;

import com.codenation.java.women.errorcenter.entity.Log;
import com.codenation.java.women.errorcenter.repository.LogRepository;
import com.codenation.java.women.errorcenter.service.interfaces.LogServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service("logService")
public class LogService implements LogServiceInterface {

    private final LogRepository repository;

    public LogService(LogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Log> get() {
        return repository.findAll();
    }

    @Override
    public Optional<Log> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Log save(Log log) {
        return repository.save(log);
    }

    @Override
    public Optional<Log> update(Log newLog, Long id) {
        return repository.findById(id).
                map( log -> {
                    //setIfNotNull(log::setAppId, newLog.getAppId());
                    setIfNotNull(log::setCreatedAt, newLog.getCreatedAt());
                    setIfNotNull(log::setEnviroment, newLog.getEnviroment());
                    setIfNotNull(log::setLogType, newLog.getLogType());
                    setIfNotNull(log::setDate, newLog.getDate());

                    return repository.save(log);
                });
    }

    @Override
    public void deleteByID(Long id) {
        Optional<Log> log = get(id);

        if(!log.isPresent()) {
            repository.deleteById(id);
        }
//        else {
//            throw new LogNotFoundException(id);
//        }
    }

    private <T, voi> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
