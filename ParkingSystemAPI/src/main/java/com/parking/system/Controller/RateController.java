package com.parking.system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.system.Entities.Rate;
import com.parking.system.Services.RateService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rate")
public class RateController {

	@Autowired
	private RateService rateService;

	@PostMapping
	public Rate create(@RequestBody Rate rate) {
		return rateService.create(rate);
	}

	@GetMapping(path = { "/{id}" })
	public Rate findOne(@PathVariable("id") int id) throws Exception {
		return rateService.findrate(id);
	}

	@PutMapping(path= {"/{id}"})
	public Rate update(@RequestBody Rate rate,@PathVariable("id") int id) throws Exception {
		return rateService.update(id, rate);
	}

	@DeleteMapping(path = { "/{id}" })
	public Rate delete(@PathVariable("id") int id) throws Exception {
		return rateService.delete(id);
	}

	@GetMapping
	public List<Rate> getAllrate() {
		return rateService.findAll();
	}

}
