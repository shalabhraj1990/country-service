package com.spring.boot.country.service;

import java.util.List;

import com.spring.boot.country.controller.modal.City;
import com.spring.boot.country.controller.modal.Country;

public interface CountryService {
	
	
	List<Country> getAllCountry();

	Country getCountryByCountryCode(String countryCode);

	City getCityByName(String cityName);

}
