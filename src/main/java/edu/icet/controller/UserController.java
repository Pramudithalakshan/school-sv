package edu.icet.controller;

import edu.icet.dto.UserDto;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/getAll")
    public List<UserDto> getAll(){
        return userService.getUsers();
    }
}
