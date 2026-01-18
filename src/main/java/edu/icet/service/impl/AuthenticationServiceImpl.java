package edu.icet.service.impl;

import edu.icet.dto.AuthenticationResponse;
import edu.icet.dto.UserDto;
import edu.icet.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.security.ApplicationConfig;
import edu.icet.service.AuthenticationService;
import edu.icet.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ApplicationConfig applicationConfig;
    @Override
    public AuthenticationResponse register(UserDto userDto) {
        User user =  User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(applicationConfig.passwordEncoder().encode(userDto.getPassword()))
                .role(userDto.getRole())
                .build();
        repository.save(user);

        String jwtToken = jwtService.generateToken(user.getUsername());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(UserDto userDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()
                )
        );
        User user = repository.findByUsername(userDto.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        String jwtToken = jwtService.generateToken(user.getUsername());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
