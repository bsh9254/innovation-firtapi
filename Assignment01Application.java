package com.sparta.assignment01;

import com.sparta.assignment01.domain.AssignmentRepository;
import com.sparta.assignment01.service.AssignmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Assignment01Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment01Application.class, args);
    }


}