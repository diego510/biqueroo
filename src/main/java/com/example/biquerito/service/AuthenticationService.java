package com.example.biquerito.service;

import com.example.biquerito.domain.Role;
import com.example.biquerito.domain.User;
import com.example.biquerito.dto.JwtAuthenticationResponse;
import com.example.biquerito.dto.SignUpRequest;
import com.example.biquerito.dto.SigninRequest;
import com.example.biquerito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        if (request.getAdmin()) {
            user.setRole(Role.ADMIN);
        }

        userRepository.save(user);
        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;
    }

    public JwtAuthenticationResponse signin(SigninRequest request) throws IllegalArgumentException {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail());
        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;
    }
}
