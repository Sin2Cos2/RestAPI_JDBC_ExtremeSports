package com.attaproject.mapper;

import com.attaproject.model.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {

    public static final String BASE_SQL = "Select * from locations l";
    public static final String DELETE_SQL = "DELETE from locations l";
    public static final String POST_SQL = "INSERT INTO locations(location_name, region_id, country_id)";

    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("id");
        String name = rs.getString("location_name");
        Integer regionId = rs.getInt("region_id");
        Integer countryId = rs.getInt("country_id");



        return new Location(id, name, regionId, countryId);
    }
}
