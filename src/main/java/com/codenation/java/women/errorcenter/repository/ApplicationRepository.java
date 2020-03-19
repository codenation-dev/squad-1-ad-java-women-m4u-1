package com.codenation.java.women.errorcenter.repository;

import com.codenation.java.women.errorcenter.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {
}
