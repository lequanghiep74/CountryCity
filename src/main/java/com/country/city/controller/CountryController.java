package com.country.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.country.city.entity.Country;
import com.country.city.intface.CountryRepository;

@RestController
@RequestMapping("/api")
public class CountryController {
	
	@Autowired
	CountryRepository countryRepository;
	
	@GetMapping("/notes")
	public List<Country> getAllCountrys() {
		return null;
	}
	
}
