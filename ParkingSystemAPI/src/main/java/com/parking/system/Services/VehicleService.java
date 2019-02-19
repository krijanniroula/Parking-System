package com.parking.system.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.system.Entities.Vehicle;
import com.parking.system.Repository.VehicleRepository;

import javassist.NotFoundException;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}
	
	public Vehicle findVehicle(int id) throws Exception{
		return vehicleRepository.findById(id).orElseThrow(()-> new NotFoundException("Vehicle Not Found on :: "+id));
	}
	
	public Vehicle create(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	public Vehicle delete(int id) throws Exception{
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()-> new NotFoundException("Vehicle Not Found on :: "+id));
		vehicleRepository.delete(vehicle);
		return vehicle;
	}
	
	public Vehicle update(int id,Vehicle vehicle1) throws Exception{
		
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()-> new NotFoundException("Vehicle Not Found on :: "+id));
	
		if(vehicle1.getVNumber()!=null) {
			vehicle.setVNumber(vehicle1.getVNumber());
		}
		if(vehicle1.getVType()!=null) {
			vehicle.setVType(vehicle1.getVType());
		}
	
		return vehicleRepository.save(vehicle);
	}

}
