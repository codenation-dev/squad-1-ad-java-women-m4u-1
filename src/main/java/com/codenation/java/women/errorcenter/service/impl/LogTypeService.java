package com.codenation.java.women.errorcenter.service.impl;

import com.codenation.java.women.errorcenter.dto.LogTypeDTO;
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
    public List<LogTypeDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<LogTypeDTO> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<LogTypeDTO> save(LogTypeDTO logType) {
        return repository.save(Optional.ofNullable(logType));
    }

    @Override
    public Optional<LogTypeDTO> update(LogTypeDTO newLogType, Long id) {
        Optional<LogTypeDTO> logType = repository.findById(id);
        return repository.save(logType);
    }

    @Override
    public void deleteByID(Long id) {
        Optional<LogTypeDTO> logType = findById(id);

        if(!logType.isPresent()) {
            repository.deleteById(id);
        } else {
            //throw new PessoaNotFoundException(id);
        }
    }

    private <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
