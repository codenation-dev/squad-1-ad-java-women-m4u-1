package com.codenation.java.women.errorcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Log extends JpaRepository<Log, Long> {
}
