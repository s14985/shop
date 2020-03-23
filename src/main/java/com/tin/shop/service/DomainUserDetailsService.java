package com.tin.shop.service;

import com.tin.shop.model.User;
import com.tin.shop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        String email = login.toLowerCase(Locale.ENGLISH);
        return userRepository.findByEmail(email)
                .map(user -> createSpringSecurityUser((User) user))
                .orElseThrow(() -> new UsernameNotFoundException("User with email" + email + " was not found in the database"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getAuthorities());
    }
}
