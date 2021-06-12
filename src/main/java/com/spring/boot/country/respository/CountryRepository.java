package com.spring.boot.country.respository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.boot.country.controller.modal.City;
import com.spring.boot.country.controller.modal.Country;

@Repository
public class CountryRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select code,name,region,population,continent from country", new CountryRowMapper());
	}

	static class CountryRowMapper implements RowMapper<Country> {

		@Override
		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new Country();
			country.setCode(rs.getString("Code"));
			country.setContinent(rs.getString("Continent"));
			country.setName(rs.getString("Name"));
			country.setDescription(rs.getString("Region"));
			country.setPopulation(rs.getLong("Population"));
			country.setRegion(rs.getString("Region"));
			return country;
		}

	}

	static class CityRowMapper implements RowMapper<City> {

		@Override
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
			return City.builder().id(rs.getInt("ID")).countryCode(rs.getString("countryCode"))
					.district(rs.getString("district")).name(rs.getString("name"))
					.population(rs.getDouble("population")).build();
		}

	}

	public Country getCountryByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select code,name,region,population,continent from country where code = ?",
				new CountryRowMapper(), new Object[] { countryCode });
	}

	public City getCityByName(String cityName) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from city where name = ?", new CityRowMapper(),
				new Object[] { cityName });
	}
}
