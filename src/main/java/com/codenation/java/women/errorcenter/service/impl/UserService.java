package com.codenation.java.women.errorcenter.service.impl;

import com.codenation.java.women.errorcenter.dto.UserDTO;
import com.codenation.java.women.errorcenter.repository.UserRepository;
import com.codenation.java.women.errorcenter.service.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<UserDTO> save(UserDTO user) {
        return repository.save(Optional.ofNullable(user));
    }

    @Override
    public Optional<UserDTO> update(UserDTO newUser, Long id) {
        Optional<UserDTO> user = repository.findById(id);
        return repository.save(user);
    }

    @Override
    public void deleteByID(Long id) {
        Optional<UserDTO> user = findById(id);

        if(!user.isPresent()) {
            repository.deleteById(id);
        } else {
            //throw new PessoaNotFoundException(id);
        }
    }

    private <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
