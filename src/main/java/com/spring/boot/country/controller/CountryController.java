package com.spring.boot.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.country.controller.modal.City;
import com.spring.boot.country.controller.modal.Country;
import com.spring.boot.country.service.CountryService;

import msk.spring.boot.common.dto.Response;

@RestController
@RequestMapping("country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping
	public ResponseEntity<Response<List<Country>>> getAllCountry() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryService.getAllCountry());
	}
	
	@GetMapping("/{country-code}")
	public ResponseEntity<Response<Country>> getCountryByCountryCode(@PathVariable("country-code") String countryCode) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryService.getCountryByCountryCode(countryCode));
	}
	
	@GetMapping("/city/{city-name}")
	public ResponseEntity<Response<City>> getCityByName(@PathVariable("city-name") String cityName) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryService.getCityByName(cityName));
	}

}
