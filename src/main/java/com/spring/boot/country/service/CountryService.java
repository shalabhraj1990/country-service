package com.spring.boot.country.service;

import java.util.List;

import com.spring.boot.country.controller.modal.City;
import com.spring.boot.country.controller.modal.Country;

import msk.spring.boot.common.dto.Response;

public interface CountryService {
	
	
	Response<List<Country>> getAllCountry();

	Response<Country> getCountryByCountryCode(String countryCode);

	Response<City> getCityByName(String cityName);

}
