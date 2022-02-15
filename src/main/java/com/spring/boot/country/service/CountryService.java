package com.spring.boot.country.service;

import java.util.List;

import msk.spring.boot.common.dto.Response;
import msk.spring.boot.common.mobile.dto.City;
import msk.spring.boot.common.mobile.dto.Country;

public interface CountryService {
	
	
	Response<List<Country>> getAllCountry();

	Response<Country> getCountryByCountryCode(String countryCode);

	Response<City> getCityByName(String cityName);

}
