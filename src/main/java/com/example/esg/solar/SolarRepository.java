package com.example.esg.solar;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface SolarRepository extends CrudRepository<SolarDTO, Integer> {
	@Query(value="SELECT * FROM solardetails WHERE country = :country AND region = :region AND province = :province", nativeQuery = true)
	SolarDTO findByConditions(@Param("country") String country,
                                      @Param("region") String region,
                                      @Param("province") String province);

}
