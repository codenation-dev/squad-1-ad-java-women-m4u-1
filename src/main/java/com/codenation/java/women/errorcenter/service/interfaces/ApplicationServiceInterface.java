package com.codenation.java.women.errorcenter.service.interfaces;

import com.codenation.java.women.errorcenter.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationServiceInterface {
    List<Application> get();
    Optional<Application> get(Long id);
    Application save(Application application);
    Optional<Application> update(Application application, Long id);
    void deleteByID(Long id);
}
