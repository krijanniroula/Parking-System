package com.parking.system.Entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends BaseEntity{

	@NotEmpty
	private String vType;
	
	@NotEmpty
	private String vNumber;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="vehicle")
	 @JsonIgnore
	private Set<Details> details= new HashSet<>();
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime created_at;

	@UpdateTimestamp
	private LocalDateTime updated_at;
}
