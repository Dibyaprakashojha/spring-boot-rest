package com.productapp.service;

import com.productapp.model.JWTUser;
import com.productapp.repository.JWTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JWTUserServiceImpl implements UserDetailsService {

    @Autowired
    private JWTUserRepository jwtUserRepository;

    // for new users
    public void addUser(JWTUser user) {
        jwtUserRepository.save(user);
    }

    // for getting the existing users
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JWTUser user =  jwtUserRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("Invalid username");
        // create the roles and authorities
        List<GrantedAuthority> authorities = Arrays.asList(
                new SimpleGrantedAuthority("ADMIN"),
                new SimpleGrantedAuthority("USER")
        );
        // create the inbuilt user object using the data
        UserDetails userDetails = new User(user.getUsername(),user.getPassword(),authorities);
        // return the user object with the roles
        return userDetails;
    }


}
