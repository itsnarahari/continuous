package com.continuous.boot.controller;

import com.continuous.boot.models.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JtRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println(rowNum);
        return new Users(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
    }
}
