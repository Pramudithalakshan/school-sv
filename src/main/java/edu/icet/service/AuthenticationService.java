package edu.icet.service;

import edu.icet.dto.AuthenticationResponse;
import edu.icet.dto.UserDto;

public interface AuthenticationService {
    AuthenticationResponse register(UserDto userDto);
    AuthenticationResponse authenticate(UserDto userDto);
}
