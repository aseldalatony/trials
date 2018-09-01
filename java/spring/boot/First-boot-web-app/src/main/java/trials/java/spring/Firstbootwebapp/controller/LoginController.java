package trials.java.spring.Firstbootwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import trials.java.spring.Firstbootwebapp.service.ValidationService;

@Controller
public class LoginController {

	@Autowired
	ValidationService service;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello, spring boot ";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap map, @RequestParam String name, @RequestParam String pass) {
		if (!service.validateUserAndPass(name, pass)) {
			map.put("message", "Invalid login");
			return "login";
		}
		map.put("name", name);
		return "welcome";
	}

}
