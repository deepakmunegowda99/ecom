package com.ecom.ecommerce.security;

import com.ecom.ecommerce.exception.ResourceNotFoundException;
import com.ecom.ecommerce.model.User;
import com.ecom.ecommerce.repository.UserRepository;
import com.ecom.ecommerce.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail));

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id, Long time) {
        User user = userRepository.findByUserId(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        if (!sessionRepository.existsByUserAndLoggedinAndLoggedintime(user, 1, time)) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        return UserPrincipal.create(user);
    }
}