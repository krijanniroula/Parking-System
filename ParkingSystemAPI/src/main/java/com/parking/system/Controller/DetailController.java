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

import com.parking.system.Entities.Details;
import com.parking.system.Services.DetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/records")
public class DetailController {

	@Autowired
	private DetailsService detailsService;

	@PostMapping
	public Details create(@RequestBody Details details) {
		return detailsService.create(details);
	}

	@GetMapping(path = { "/{id}" })
	public Details findOne(@PathVariable("id") int id) throws Exception {
		return detailsService.findDetail(id);
	}

	@PutMapping(path= {"/{id}"})
	public Details update(@RequestBody Details details,@PathVariable("id") int id) throws Exception {
		return detailsService.update(id, details);
	}

	@DeleteMapping(path = { "/{id}" })
	public Details delete(@PathVariable("id") int id) throws Exception {
		return detailsService.delete(id);
	}

	@GetMapping
	public List<Details> getAllDetails() {
		return detailsService.findAll();
	}

}
