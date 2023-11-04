package com.example.esg.register;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.esg.exceptions.InvalidDataExceptions;




@Service
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;

	
	
	
	public Boolean registerUser(Register user) {
		RegisterDTO registerDTO=converToDTO(user);
		RegisterDTO registeredUser=registerRepository.findByEmailId(user.getEmailAddress());
		//String decodedPassword = new String(Base64.getDecoder().decode(registeredUser.getPassword()));
		if((registeredUser!=null)){
			throw new InvalidDataExceptions("Email ID already Exists");
		}
		RegisterDTO respObj=registerRepository.save(registerDTO);
		if(respObj!=null) {
			//sendEmail(registerDTO.getEmailAddress(),user.getFirstName(),"registration_successful");
		 return true;
		}
		else
			return false;
	}
	
	
	public RegisterDTO converToDTO(Register user) {	
		RegisterDTO userDTO=new RegisterDTO();
		userDTO.setEmailAddress(user.getEmailAddress());
		userDTO.setPassword(user.getPassword());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setCountry(user.getCountry());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		userDTO.setRole(user.getRole());
		userDTO.setAccountStatus("Active");
		userDTO.setCompany(user.getCompany());
		userDTO.setSector(user.getSector());
		return userDTO;
	}
	
}
