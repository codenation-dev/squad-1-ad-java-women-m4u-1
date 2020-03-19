package com.codenation.java.women.errorcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Application extends JpaRepository<Long, com.codenation.java.women.errorcenter.entity.Application> {
}
