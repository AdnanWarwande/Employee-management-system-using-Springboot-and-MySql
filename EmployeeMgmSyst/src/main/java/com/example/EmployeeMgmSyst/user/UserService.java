package com.example.EmployeeMgmSyst.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int authenticate(String username, String password) {
        String sql = "SELECT authenticate_user(?, ?)";
        return jdbcTemplate.queryForObject(sql, Integer.class, username, password);
    }

    public void registerUser(String username, String password) {
        String sql = "CALL register_user(?, ?)";
        jdbcTemplate.update(sql, username, password);
    }
}

