package com.spring.boot.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.country.controller.modal.City;
import com.spring.boot.country.controller.modal.Country;
import com.spring.boot.country.respository.CountryRepository;

import msk.spring.boot.common.dto.Response;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public Response<List<Country>> getAllCountry() {
		// TODO Auto-generated method stub
		List<Country> countries = countryRepository.getAllCountry();
		return Response.<List<Country>>builder().data(countries).build();
	}

	@Override
	public Response<Country> getCountryByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		Country country = countryRepository.getCountryByCountryCode(countryCode);
		return Response.<Country>builder().data(country).build();
	}

	@Override
	public Response<City> getCityByName(String cityName) {
		// TODO Auto-generated method stub
		City city = countryRepository.getCityByName(cityName);
		return Response.<City>builder().data(city).build();
	}

}
