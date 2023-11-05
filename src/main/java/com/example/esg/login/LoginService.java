package  com.example.esg.login;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.esg.exceptions.InvalidDataExceptions;
import com.example.esg.register.RegisterDTO;
import com.example.esg.register.RegisterRepository;


@Service
public class LoginService {
	
	@Autowired
	private RegisterRepository registerRepository;
	
	
	public RegisterDTO authenticate(String userName,String password) {
		RegisterDTO registeredUser=registerRepository.findByEmailId(userName);
		//String decodedPassword = new String(Base64.getDecoder().decode(registeredUser.getPassword()));
		if((registeredUser!=null) && (!registeredUser.getPassword().equals(password))){
			throw new InvalidDataExceptions("Invalid User Credentials");
		}
		return registeredUser;
	}
	
}

