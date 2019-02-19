package com.parking.system.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.system.Entities.Rate;
import com.parking.system.Repository.RateRepository;

import javassist.NotFoundException;

@Service
public class RateService {

	@Autowired
	private RateRepository rateRepository;

	public List<Rate> findAll() {
		return rateRepository.findAll();
	}

	public Rate findrate(int id) throws Exception {
		return rateRepository.findById(id).orElseThrow(() -> new NotFoundException("rate Not Found on :: " + id));
	}

	public Rate create(Rate rate) {
		return rateRepository.save(rate);
	}

	public Rate delete(int id) throws Exception {
		Rate rate = rateRepository.findById(id).orElseThrow(() -> new NotFoundException("rate Not Found on :: " + id));
		rateRepository.delete(rate);
		return rate;
	}

	public Rate update(int id, Rate rate1) throws Exception {

		Rate rate = rateRepository.findById(id).orElseThrow(() -> new NotFoundException("rate Not Found on :: " + id));

		if (rate1.getRate() != null) {
			rate.setRate(rate1.getRate());
		}
		if (rate1.getUnit() != null) {
			rate.setUnit(rate1.getUnit());
		}
		

		return rateRepository.save(rate);
	}

}
