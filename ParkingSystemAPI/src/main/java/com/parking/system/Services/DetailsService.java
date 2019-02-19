package com.parking.system.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.system.Entities.Details;
import com.parking.system.Repository.DetailsRepository;

import javassist.NotFoundException;

@Service
public class DetailsService {
	
	@Autowired
	private DetailsRepository detailsRepository;
	
	public List<Details> findAll(){
		
		return detailsRepository.findAll();
	}
	
	public Details findDetail(int id) throws Exception{
		return detailsRepository.findById(id).orElseThrow(()-> new NotFoundException("Record Not Found on :: "+id));
	}
	
	public Details create(Details detail) {
		return detailsRepository.save(detail);
	}
	
	public Details delete(int id) throws Exception{
		Details detail = detailsRepository.findById(id).orElseThrow(()-> new NotFoundException("Record Not Found on :: "+id));
        detailsRepository.delete(detail);
        return detail;
	}

	public Details update(int id,Details record) throws Exception{
		
		Details detail = detailsRepository.findById(id).orElseThrow(()-> new NotFoundException("Record Not Found on :: "+id));
	
		if(record.getDate()!=null) {
			detail.setDate(record.getDate());
		}
		
		if(record.getDay()!=null) {
			detail.setDay(record.getDay());
		}
	
		if(record.getVehicle()!=null) {
			detail.setVehicle(record.getVehicle());
		}
		
		if(record.getTimeIn()!=null) {
			detail.setTimeIn(record.getTimeIn());
		}
		
		if(record.getTimeOut()!=null) {
			detail.setTimeOut(record.getTimeOut());
		}
		
		return detailsRepository.save(detail);
	}

}
