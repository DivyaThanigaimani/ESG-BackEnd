package com.example.esg.region;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface regionRepository extends CrudRepository<regionDTO, Long> {
	
	@Query("SELECT SUM(emission_amt) FROM regionDTO")
    double getTotalEmissionForCanada();
}

