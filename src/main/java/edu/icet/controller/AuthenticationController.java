package edu.icet.controller;

import edu.icet.dto.AuthenticationResponse;
import edu.icet.dto.UserDto;
import edu.icet.service.impl.AuthenticationServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationServiceImpl service;
    @PostMapping("/register")
    public ResponseEntity<@NonNull AuthenticationResponse> register(@RequestBody UserDto userDto){
        return ResponseEntity.ok(service.register(userDto));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<@NonNull AuthenticationResponse> authenticate(@RequestBody UserDto userDto){
        return  ResponseEntity.ok(service.authenticate(userDto));
    }
}
