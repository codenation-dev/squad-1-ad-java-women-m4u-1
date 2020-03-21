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
    CommandLineRunner initDatabaseUser(UserRepository repository) {
        LocalDateTime localDate      = LocalDateTime.now();
        List<Application> applications = new ArrayList<Application>();

        return args -> {
            repository.save(new User("Ágatha Serafim", "XXXXXXXXX", "agathamariana@gmail.com", "123", localDate, applications));
            repository.save(new User("Julia Kastrup", "YYYYYYYY", "juliakastrup@gmail.com", "456", localDate, applications));
            repository.save(new User("Julia Paranhos", "WWWWWWWWW", "juliaparanhos@gmail.com", "789", localDate, applications));
            repository.save(new User("Natália Viveiros", "KKKKKKKKK", "nataliaviveiros@gmail.com", "999", localDate, applications));
        };
    }

}
