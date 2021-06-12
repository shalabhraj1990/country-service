package com.spring.boot.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.country.controller.modal.City;
import com.spring.boot.country.controller.modal.Country;
import com.spring.boot.country.service.CountryService;

@RestController
@RequestMapping("country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping
	public List<Country> getAllCountry() {
		return countryService.getAllCountry();
	}
	
	@GetMapping("/{country-code}")
	public Country getCountryByCountryCode(@PathVariable("country-code") String countryCode) {
		return countryService.getCountryByCountryCode(countryCode);
	}
	
	@GetMapping("/city/{city-name}")
	public City getCityByName(@PathVariable("city-name") String cityName) {
		return countryService.getCityByName(cityName);
	}

}
