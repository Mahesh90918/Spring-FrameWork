package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	// http://localhost:6253/12SpringMvcHelloWorld/hello?name=mahesh1
	public ModelAndView display(@RequestParam("name") String name) {
		// jsp page name
		return new ModelAndView("helloworld", "name", name);
	}

	@RequestMapping("/welcome/{sarada}")
	// http://localhost:6253/12SpringMvcHelloWorld/welcome/mahesh
	public ModelAndView welcome(@PathVariable("sarada") String name) {
		// jsp page name
		return new ModelAndView("welcome", "sarada", name);
	}

}
