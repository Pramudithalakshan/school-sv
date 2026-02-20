package edu.icet.service;

import edu.icet.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
