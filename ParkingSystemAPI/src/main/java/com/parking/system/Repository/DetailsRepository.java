package com.parking.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.system.Entities.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer>{

}
