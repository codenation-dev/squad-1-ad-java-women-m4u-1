package com.codenation.java.women.errorcenter.service.impl;

import com.codenation.java.women.errorcenter.entity.User;
import com.codenation.java.women.errorcenter.exception.UserNotFoundException;
import com.codenation.java.women.errorcenter.repository.UserRepository;
import com.codenation.java.women.errorcenter.service.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service("userService")
public class UserService implements UserServiceInterface {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> get() {
        return repository.findAll();
    }

    @Override
    public Optional<User> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> update(User newUser, Long id) {
        return repository.findById(id).
                map(user -> {
                    setIfNotNull(user::setName, newUser.getName());
                    setIfNotNull(user::setEmail, newUser.getEmail());
                    setIfNotNull(user::setPassword, newUser.getPassword());

                    return repository.save(user);
                });
    }

    @Override
    public void deleteByID(Long id) {
        Optional<User> user = get(id);

        if(!user.isPresent()) {
            repository.deleteById(id);
        }
        else {
            throw new UserNotFoundException(id);
        }
    }

    private <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}


