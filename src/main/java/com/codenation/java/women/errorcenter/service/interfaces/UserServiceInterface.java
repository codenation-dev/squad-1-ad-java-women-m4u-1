package com.codenation.java.women.errorcenter.service.interfaces;


import com.codenation.java.women.errorcenter.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    List<User> get();
    Optional<User> get(Long id);
    User save(User user);
    Optional<User> update(User user, Long id);
    void deleteByID(Long id);
}
