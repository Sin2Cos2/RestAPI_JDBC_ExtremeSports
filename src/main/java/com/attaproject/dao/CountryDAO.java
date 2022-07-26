package com.attaproject.dao;

import com.attaproject.mapper.CountryMapper;
import com.attaproject.model.Country;
import com.attaproject.requestForm.CountryRequest;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CountryDAO extends JdbcDaoSupport{

    public CountryDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Country> getCountries(){
        String sql = CountryMapper.BASE_SQL;
        CountryMapper countryMapper = new CountryMapper();
        assert this.getJdbcTemplate() != null;

        return this.getJdbcTemplate().query(sql, countryMapper, new Object[]{});
    }

    public Country getCountry(String name){

        String sql = CountryMapper.BASE_SQL + " where c.country_name like ?";
        CountryMapper mapper = new CountryMapper();
        assert this.getJdbcTemplate() != null;

        return this.getJdbcTemplate().queryForObject(sql, mapper, name);
    }

    public Country getCountry(Integer id){

        String sql = CountryMapper.BASE_SQL + " where c.id = ?";
        CountryMapper mapper = new CountryMapper();
        assert this.getJdbcTemplate() != null;

        return this.getJdbcTemplate().queryForObject(sql, mapper, id);
    }

    public boolean deleteCountry(Country country) {
        String sql = CountryMapper.DELETE_SQL + " where c.id = ?";

        assert this.getJdbcTemplate() != null;
        return this.getJdbcTemplate().update(sql, country.getId()) == 1;
    }

    public boolean addCountry(CountryRequest country) {
        String sql = CountryMapper.POST_SQL + " values(?)";

        assert this.getJdbcTemplate() != null;
        return this.getJdbcTemplate().update(sql, country.getName()) == 1;
    }
}
