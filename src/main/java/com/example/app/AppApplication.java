package com.example.app;

import com.example.app.domain.Event;
import com.example.app.domain.User;
import com.example.app.domain.Ministry;
import com.example.app.repositories.EventRepository;
import com.example.app.repositories.UserRepository;
import com.example.app.repositories.MinistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MinistryRepository ministryRepository;
    @Autowired
    private EventRepository eventRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


    }
}
