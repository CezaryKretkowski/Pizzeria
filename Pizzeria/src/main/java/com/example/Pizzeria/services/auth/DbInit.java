package com.example.Pizzeria.services.auth;

import com.example.Pizzeria.entities.users.User;
import com.example.Pizzeria.repositories.StaticFileRepository;
import com.example.Pizzeria.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DbInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final StaticFileRepository staticFileRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public void run(String... args) {

        this.userRepository.deleteAll();
        User admin = User.builder().id(1).email("Admin@gmail.com").password(passwordEncoder.encode("admin")).build();

        this.userRepository.save(admin);
    }
}