package edu.icet.service.impl;

import edu.icet.dto.UserDto;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<UserDto> getUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(UserDto.class));
    }
}
