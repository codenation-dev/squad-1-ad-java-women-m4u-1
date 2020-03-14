package com.codenation.java.women.errorcenter.service.impl;

import com.codenation.java.women.errorcenter.dto.ApplicationDTO;
import com.codenation.java.women.errorcenter.dto.UserDTO;
import com.codenation.java.women.errorcenter.repository.ApplicationRepository;
import com.codenation.java.women.errorcenter.service.interfaces.ApplicationServiceInterface;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ApplicationService implements ApplicationServiceInterface {

    private final ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ApplicationDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ApplicationDTO> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ApplicationDTO> save(ApplicationDTO application) {
        return repository.save(Optional.ofNullable(application));
    }

    @Override
    public Optional<ApplicationDTO> update(ApplicationDTO newApplication, Long id) {
        Optional<ApplicationDTO> application = repository.findById(id);
        return repository.save(application);
    }

    @Override
    public void deleteByID(Long id) {
        Optional<ApplicationDTO> application = findById(id);

        if(!application.isPresent()) {
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
