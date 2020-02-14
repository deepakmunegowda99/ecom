package com.ecom.ecommerce.controller;

import javax.validation.Valid;

import com.ecom.ecommerce.model.Role;
import com.ecom.ecommerce.model.RoleName;
import com.ecom.ecommerce.model.User;
import com.ecom.ecommerce.model.Session;

import com.ecom.ecommerce.payload.LoginRequest;
import com.ecom.ecommerce.payload.SignUpRequest;
import com.ecom.ecommerce.repository.RoleRepository;
import com.ecom.ecommerce.repository.SessionRepository;
import com.ecom.ecommerce.repository.UserRepository;
import com.ecom.ecommerce.response.ApiResponse;
import com.ecom.ecommerce.response.JwtAuthenticationResponse;
import com.ecom.ecommerce.security.JwtTokenProvider;
import com.ecom.ecommerce.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    SessionRepository sessionRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

        UserPrincipal userPrin = (UserPrincipal) authentication.getPrincipal();

        User user = new User(userPrin.getId(), userPrin.getName(), userPrin.getUsername(), userPrin.getEmail(),
                userPrin.getPassword());

        if (sessionRepository.existsByUserAndLoggedin(user, 1)) {
            return new ResponseEntity(new ApiResponse(false, "User already logged In"), HttpStatus.BAD_REQUEST);
        }
        Long date = new Date().getTime();
        Session session = new Session(user, "1012023", 1, date, date);

        sessionRepository.save(session);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication, date);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER);
        if (userRole == null) {
            return ResponseEntity.ok().body(new ApiResponse(true, "Role not set"));
        }

        user.setRole(userRole);

        User result = userRepository.save(user);

        return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {

        UserPrincipal userPrin = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Session sess = sessionRepository.findByUserAndLoggedin(new User(userPrin.getId()), 1);
        if (sess == null) {
            return new ResponseEntity(new ApiResponse(false, "Try again"), HttpStatus.FAILED_DEPENDENCY);
        }
        sess.setloggedin(0);
        sess.setloggedouttime(new Date().getTime());
        sessionRepository.save(sess);
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();

        return ResponseEntity.ok().body(new ApiResponse(true, "User logged out successfully"));
    }

}