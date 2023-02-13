package com.example.eshop.services;


import com.example.eshop.entities.User;
import com.example.eshop.enums.Role;
import com.example.eshop.exceptions.UserExistException;
import com.example.eshop.payload.request.LoginRequest;
import com.example.eshop.payload.request.SignupRequest;
import com.example.eshop.payload.response.AuthenticationResponse;
import com.example.eshop.repositories.UserRepository;
import com.example.eshop.security.JwtService;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    public final static Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signup(SignupRequest request) {
        if (userRepository.findUserByEmail(request.getEmail()).isPresent()) {
            throw new UserExistException("The user with email " + request.getEmail() + " already exist");
        }

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(bcryptPasswordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        try {
            userRepository.save(user);
            LOG.info("Saving User {}", request.getEmail());
        } catch (UserExistException exception) {
            LOG.error("Registration error {}", exception.getMessage());
        }

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
