package com.parking.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.system.Entities.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer>{

}
