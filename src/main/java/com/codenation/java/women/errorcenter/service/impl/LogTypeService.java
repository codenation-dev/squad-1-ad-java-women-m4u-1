package com.codenation.java.women.errorcenter.service.impl;

import com.codenation.java.women.errorcenter.entity.LogType;
import com.codenation.java.women.errorcenter.repository.LogTypeRepository;
import com.codenation.java.women.errorcenter.service.interfaces.LogTypeServiceInterface;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class LogTypeService implements LogTypeServiceInterface {

    private final LogTypeRepository repository;

    public LogTypeService(LogTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LogType> get() {
        return repository.findAll();
    }

    @Override
    public Optional<LogType> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public LogType save(LogType logType) {
        return repository.save(logType);
    }

    @Override
    public Optional<LogType> update(LogType newLogType, Long id) {
        return repository.findById(id).
                map(logType -> {
                    setIfNotNull(logType::setTitle, newLogType.getTitle());
                    setIfNotNull(logType::setDescription, newLogType.getDescription());
                    setIfNotNull(logType::setErrorLevel, newLogType.getErrorLevel());

                    return repository.save(logType);
                });
    }

    @Override
    public void deleteByID(Long id) {
        Optional<LogType> logType = get(id);

        if(!logType.isPresent()) {
            repository.deleteById(id);
        }
//        else {
//            throw new LogTypeNotFoundException(id);
//        }
    }

    private <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
