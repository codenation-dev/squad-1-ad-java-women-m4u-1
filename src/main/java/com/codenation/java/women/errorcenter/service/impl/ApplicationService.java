package com.codenation.java.women.errorcenter.service.impl;

import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.exception.ApplicationNotFoundException;
import com.codenation.java.women.errorcenter.repository.ApplicationRepository;
import com.codenation.java.women.errorcenter.service.interfaces.ApplicationServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service("applicationService")
public class ApplicationService implements ApplicationServiceInterface {

    private final ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Application> get() {
        return repository.findAll();
    }

    @Override
    public Optional<Application> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Application save(Application application) {
        return repository.save(application);
    }

    @Override
    public Optional<Application> update(Application newApplication, Long id) {
        return repository.findById(id).
                map(application -> {
                    setIfNotNull(application::setAppName, newApplication.getAppName());
                    setIfNotNull(application::setDescription, newApplication.getDescription());
                    setIfNotNull(application::setLogs, newApplication.getLogs());
                    setIfNotNull(application::setUsers, newApplication.getUsers());
                    setIfNotNull(application::setUserId, newApplication.getUserId());
                    setIfNotNull(application::setCreatedAt, newApplication.getCreatedAt());

                    return repository.save(application);
                });
    }

    @Override
    public void deleteByID(Long id) {
        Optional<Application> application = get(id);

        if(!application.isPresent()) {
            repository.deleteById(id);
        }
        else {
            throw  new ApplicationNotFoundException(id);
        }
    }

    private <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
