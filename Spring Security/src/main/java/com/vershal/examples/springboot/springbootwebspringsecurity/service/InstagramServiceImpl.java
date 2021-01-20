package com.vershal.examples.springboot.springbootwebspringsecurity.service;

import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.exceptions.IGLoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class InstagramServiceImpl {

    private static Logger logger = LoggerFactory.getLogger(InstagramServiceImpl.class);

    public IGClient login(String username, String password) {
        IGClient client = null;
        try {
            IGClient.builder()
                    .username(username)
                    .password(password)
                    .login();
        } catch (IGLoginException e) {
            logger.error(username + " user with " + password + " password doesn't exist");
        }
        return client;
    }

    public void uploadPhotoToInstagram(String username, String password) {
        login(username, password).actions()
                .timeline()
                .uploadPhoto(new File("1.jpg"), "My Caption")
                .thenAccept(response -> {
                    System.out.println("Successfully uploaded photo!");
                })
                .join(); // block current thread until complete
    }
}
