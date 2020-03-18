package com.codenation.java.women.errorcenter.service.interfaces;

import com.codenation.java.women.errorcenter.dto.ApplicationDTO;

import java.util.List;
import java.util.Optional;

public interface ApplicationServiceInterface {

    List<ApplicationDTO> findAll();

    Optional<ApplicationDTO> findById(Long id);

    Optional<ApplicationDTO> save(ApplicationDTO application);

    Optional<ApplicationDTO> update(ApplicationDTO application, Long id);

    void deleteByID(Long id);
}
