package com.productapp.service;

import com.productapp.model.AppUser;
import com.productapp.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class AppUserServiceImpl implements UserDetailsService,IAppUserService {


    @Autowired
    private IAppUserRepository appUserRepository;

        // this is to do jpa authentication
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // get the user by passing the username
        AppUser appUser =  appUserRepository.findByUsername(username);
        String username1 = appUser.getUsername();
        String password = appUser.getPassword();
        // set the roles
        GrantedAuthority grantedAuthority1 = new SimpleGrantedAuthority("ADMIN");
        GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("USER");
        UserDetails user = new User(username1, password, Arrays.asList(grantedAuthority1,grantedAuthority2));
        return user;
    }

    @Override
    public void addAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void updateAppUser(AppUser user) {

    }

    @Override
    public void deleteAppUser(int userId) {

    }
}
