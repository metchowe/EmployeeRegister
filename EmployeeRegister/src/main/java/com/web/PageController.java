package com.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String clientSide() {

		return "";
	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String createEmployee() {

		return "createEmployee";
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee() {

		return "deleteEmployee";
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public String updateEmployee() {

		return "updateEmployee";
	}
	
	
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView error404(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", page not found!");
		} else {
			model.addObject("msg", 
			"Page not found!");
		}

		model.setViewName("404");
		return model;

	}
}
