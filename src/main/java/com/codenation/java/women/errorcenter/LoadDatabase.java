package com.codenation.java.women.errorcenter;

import com.codenation.java.women.errorcenter.entity.Application;
import com.codenation.java.women.errorcenter.entity.User;
import com.codenation.java.women.errorcenter.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        LocalDateTime localDate      = LocalDateTime.now();
        List<Application> applications = new ArrayList<Application>();

        return args -> {
            repository.save(new User("Ágatha Serafim", "XXXXXXXXX", "agathamariana@gmail.com", "teste", localDate, applications));
        };
    }
}
