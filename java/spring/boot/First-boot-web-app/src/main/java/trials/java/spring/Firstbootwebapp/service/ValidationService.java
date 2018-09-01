package trials.java.spring.Firstbootwebapp.service;

import org.springframework.stereotype.Component;

@Component
public class ValidationService {
	public boolean validateUserAndPass(String user, String pass) {
		return user.equalsIgnoreCase("ahmed") && pass.equals("123");
	}
}
