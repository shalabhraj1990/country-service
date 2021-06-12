package com.spring.boot.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.country.controller.modal.City;
import com.spring.boot.country.controller.modal.Country;
import com.spring.boot.country.respository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		return countryRepository.getAllCountry();
	}

	@Override
	public Country getCountryByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		return countryRepository.getCountryByCountryCode(countryCode);
	}

	@Override
	public City getCityByName(String cityName) {
		// TODO Auto-generated method stub
		return countryRepository.getCityByName(cityName);
	}

}
