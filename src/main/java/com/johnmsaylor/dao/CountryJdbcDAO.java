package com.johnmsaylor.dao;

import com.johnmsaylor.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryJdbcDAO implements DAO<Country> {

    private static final Logger log = LoggerFactory.getLogger(CountryJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    public CountryJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Country> rowMapper = ((resultSet, rowNumber) -> {
        Country country = new Country();
        country.setId(resultSet.getInt("id"));
        country.setName(resultSet.getString("name"));
        country.setPopulation(resultSet.getInt("population"));
        country.setGdp(resultSet.getInt("gdp"));
        return country;
    });

    @Override
    public List<Country> list() {
        String sql = "SELECT id, name, population, gdp FROM country";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(Country country) {
        String sql = "insert into country(name, population, gdp) values(?,?,?)";
        int rowsAffected = jdbcTemplate.update(sql, country.getName(), country.getPopulation(), country.getGdp());
        if (rowsAffected == 1) {
            System.out.println("INSERT SUCCESS: " + country.getName());
        }
    }

    @Override
    public Optional<Country> get(int id) {
        String sql = "select id, name, population, id from country where id = ?";
        Country country = null;

        try {

        } catch (Exception ex){};

        return Optional.empty();
    }

    @Override
    public void update(Country country, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
