package com.country.city.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.country.city.entity.Country;
import com.country.city.intface.CountryRepository;

@RestController
@RequestMapping("/api")
public class CountryController {
	
	@Autowired
	CountryRepository countryRepository;
	
	@GetMapping("/countries")
	public List<Country> getAllCountrys() {
		return countryRepository.findAll();
	}
	
	@PostMapping("/countries")
	public Country createCountry(@Valid @RequestBody Country coutry) {
		return countryRepository.save(coutry);
	}
	
	@GetMapping("/countries/{id}")
	public ResponseEntity<Country> getCoutryById(@PathVariable(value = "id") Long countryId) {
		Optional<Country> country = countryRepository.findById(countryId);
		
		if (country == null || country.get() == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(country.get());
	}
	
	@PutMapping("/countries/{id}")
	public ResponseEntity<Country> updateNote(@PathVariable(value = "id") Long countryId, @Valid @RequestBody Country countryDetails) {
		Country country = countryRepository.findOne(countryId);
		if (country == null) {
			return ResponseEntity.notFound().build();
		}
		
		country.setName(countryDetails.getName());
		
		Country updateCountry = countryRepository.save(country);
		
		return ResponseEntity.ok(updateCountry);
	}
	
	@DeleteMapping("/countries/{id}")
	public ResponseEntity<Country> deleteCountry(@PathVariable(value = "id") Long countryId) {
		Country country = countryRepository.findOne(countryId);
		if (country == null) {
			return ResponseEntity.notFound().build();			
		}
		
		countryRepository.delete(country);
		return ResponseEntity.ok().build();
	}
}
