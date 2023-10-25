package com.example.esg.emissiontype;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface MeasuresRepository extends CrudRepository<MeasuresDTO,Integer> {
	
	 Optional<MeasuresDTO> findByMeasures(String measures);

	    // Or if you want to directly retrieve column2
	 
}

