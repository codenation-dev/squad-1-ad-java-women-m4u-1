package com.codenation.java.women.errorcenter.service.impl;


import com.codenation.java.women.errorcenter.dto.LogDTO;
import com.codenation.java.women.errorcenter.repository.LogRepository;
import com.codenation.java.women.errorcenter.service.interfaces.LogServiceInterface;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class LogService implements LogServiceInterface {

    private final LogRepository repository;

    public LogService(LogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LogDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<LogDTO> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<LogDTO> save(LogDTO log) {
        return repository.save(Optional.ofNullable(log));
    }

    @Override
    public void deleteByID(Long id) {
        Optional<LogDTO> log = findById(id);

        if(!log.isPresent()) {
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
