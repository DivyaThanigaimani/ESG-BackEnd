package  com.example.esg.login;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.esg.register.RegisterDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
	@Autowired 
	private LoginService loginService;
	
	@GetMapping("/loginmethod/{username}/{password}")
	public ResponseEntity<RegisterDTO> getAuthentication(HttpServletRequest request,
			@PathVariable("username") String username,
			@PathVariable("password") String password) throws IOException{
		RegisterDTO registeredUser=loginService.authenticate(username,password);
		return new ResponseEntity <RegisterDTO>(registeredUser,HttpStatus.OK);
	}

}
