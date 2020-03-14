package com.codenation.java.women.errorcenter.service.interfaces;

import com.codenation.java.women.errorcenter.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    List<UserDTO> findAll();

    Optional<UserDTO> findById(Long id);

    Optional<UserDTO> save(UserDTO user);

    Optional<UserDTO> update(UserDTO user, Long id);

    void deleteByID(Long id);

}
