package com.example.esg.register;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RegisterRepository extends CrudRepository<RegisterDTO,Integer>{
	
	@Query(value = "SELECT * FROM register_user WHERE EMAIL_ADDRESS=:emailAddress", nativeQuery = true)
	RegisterDTO findByEmailId(@Param("emailAddress") String emailAddress);
}
