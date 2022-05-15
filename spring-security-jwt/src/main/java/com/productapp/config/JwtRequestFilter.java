package com.productapp.config;

import com.productapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // get the header with the name authorization from request
        String headerValue = request.getHeader("Authorization");
        String jwtToken = null;
        String username = null;

        // check if the header is not null and starts with the Bearer
        if (headerValue != null && headerValue.startsWith("Bearer")) {
            // Bearer sdtuihlkhj.fszhcg.uysfdgdh
            // substring() takes the length of the bearer+" "
            // strip the jwt token from the header
            jwtToken = headerValue.substring(7);
            // get the username from the token
            username = jwtTokenUtil.getUsernameFromToken(jwtToken);

        } else
            logger.warn("Invalid Header");

        // if the username is not null and the security context is not null
        // then specify the type of authentication

        if (username != null && SecurityContextHolder.getContext() != null) {
            // check if the username is available in the dB
            UserDetails details = userDetailsService.loadUserByUsername(username);
            List<GrantedAuthority> authorities = Arrays.asList(
                    new SimpleGrantedAuthority("ADMIN"),
                    new SimpleGrantedAuthority("USER")
            );
            // configure the authentication type
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(details.getUsername(),null, authorities);
            // set the authentication type
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // set the authentication for the security context
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        // no header means to the next filter and then to DS
        filterChain.doFilter(request, response);
    }
}
