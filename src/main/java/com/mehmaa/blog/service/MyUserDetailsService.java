package com.mehmaa.blog.service;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmaa.blog.repository.UserRepository;

/**
 * An implementation of Spring Security's UserDetailsService.
 */
@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    private UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, DataAccessException {
        if ((email == null) || email.trim().isEmpty()) {
            throw new UsernameNotFoundException("Email is null or empty");
        }

        logger.debug("Checking  users with email: " + email);

        com.mehmaa.blog.domain.User user = userRepository.findByEmail(email);

        if (user == null) {
            String errorMsg = "User with email: " + email + " could not be found";
            logger.debug(errorMsg);
            throw new UsernameNotFoundException(errorMsg);
        }

        Collection<GrantedAuthority> grantedAuthorities = toGrantedAuthorities(user.getRoleNames());
        String password = user.getPassword();
        boolean enabled = user.getIsEnabled();
        boolean userNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean userNonLocked = true;

        return new org.springframework.security.core.userdetails.User(email, password, enabled, userNonExpired, credentialsNonExpired, userNonLocked,
                grantedAuthorities);
    }

    public static Collection<GrantedAuthority> toGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> result = newArrayList();

        for (String role : roles) {
            result.add(new SimpleGrantedAuthority(role));
        }

        return result;
    }
}
