package com.vershal.examples.springboot.springbootwebspringsecurity.controller;

import com.vershal.examples.springboot.springbootwebspringsecurity.service.InstagramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private InstagramServiceImpl instagramService;

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/instagram")
    public String instagram() {
        return "/instagram";
    }

    @PostMapping("/instagram")
    public String instagramLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        instagramService.uploadPhotoToInstagram(username, password);
        return "/instagramSucess";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
