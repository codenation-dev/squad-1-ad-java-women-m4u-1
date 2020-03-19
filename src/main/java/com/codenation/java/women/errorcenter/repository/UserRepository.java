package com.codenation.java.women.errorcenter.repository;

import com.codenation.java.women.errorcenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {
}
