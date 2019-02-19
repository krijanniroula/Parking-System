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

import com.parking.system.Entities.Vehicle;
import com.parking.system.Services.VehicleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping
	public Vehicle create(@RequestBody Vehicle vehicle) {
		return vehicleService.create(vehicle);
	}

	@GetMapping(path = { "/{id}" })
	public Vehicle findOne(@PathVariable("id") int id) throws Exception {
		return vehicleService.findVehicle(id);
	}

	@PutMapping(path= {"/{id}"})
	public Vehicle update(@RequestBody Vehicle vehicle,@PathVariable("id") int id) throws Exception {
		return vehicleService.update(id, vehicle);
	}

	@DeleteMapping(path = { "/{id}" })
	public Vehicle delete(@PathVariable("id") int id) throws Exception {
		return vehicleService.delete(id);
	}

	@GetMapping
	public List<Vehicle> getAllvehicle() {
		return vehicleService.findAll();
	}

}
