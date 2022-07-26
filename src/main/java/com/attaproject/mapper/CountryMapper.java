package com.attaproject.mapper;

import com.attaproject.model.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {

    public static final String BASE_SQL = "Select * from countries c";
    public static final String DELETE_SQL = "DELETE from countries c";
    public static final String POST_SQL = "INSERT INTO countries(country_name)";

    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("id");
        String name = rs.getString("country_name");

        return new Country(id, name);
    }
}
