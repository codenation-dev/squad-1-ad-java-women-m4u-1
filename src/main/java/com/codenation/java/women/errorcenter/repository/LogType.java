package com.codenation.java.women.errorcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogType extends JpaRepository<LogType, Long> {
}
