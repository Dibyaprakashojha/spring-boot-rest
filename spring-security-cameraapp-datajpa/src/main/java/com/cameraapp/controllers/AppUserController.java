package com.cameraapp.controllers;

import com.cameraapp.model.AppUser;
import com.cameraapp.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAppUserService iAppUserService;


    @PostMapping("/")
    public void addUser(@RequestBody AppUser appUser) {
        String username = appUser.getUsername();
        String password = appUser.getPassword();
        // encode the password before saving to the dB
        String encodedPassword = passwordEncoder.encode(password);

        AppUser appUser1 = new AppUser(username, encodedPassword);
        iAppUserService.addAppUser(appUser1);
    }
}
