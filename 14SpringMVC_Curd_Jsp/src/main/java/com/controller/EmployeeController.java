package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Service.EmployeeService;
import com.bean.Employee;

//we can use this annotation in Controller Layer

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// this is Group of urls
	@RequestMapping({ "sarada", "mahesh", "home", "/" })
	public String home() {
		return "home";
	}

//	@RequestMapping({"home","mahesh","Home","/"})
//	public ModelAndView BothHomes_are_Same() {
//		String name="maheshSarada";
//		return new ModelAndView("home", "home", name);
//	}

	@RequestMapping("/addEmp")
	public String addEmp() {
		return "Save";
	}

	@RequestMapping(value = "/savemethod", method = RequestMethod.POST)
	public String saveEmp(Employee employee) {
		System.out.println("Employee : " + employee);
		employeeService.save(employee);
		return "redirect:findAll";
	}

// by default it is get method
	@RequestMapping(value = "/updatebyId")
	public String updateById(@RequestParam("Update_id") Integer id, Model model) {

		Employee employee = employeeService.findById(id);
//		getbyid details from findAll.jsp
		model.addAttribute("upemp", employee);
		// update.jsp page
		return "update";
	}

	// by it is Post method
	@RequestMapping(value = "updateEmpolyee", method = RequestMethod.POST)
	public String updateEmpolyee(Employee employee) {

		employeeService.update(employee);
//       url of findAll   
		return "redirect:findAll";
	}

	// by default it is get method
	@RequestMapping(value = "deleteEmp")
	public String deleteEmp(@RequestParam("Delete_id") Integer id) {

		employeeService.delete(id);
		return "home";
	}

	@RequestMapping(value = "/findAll")
	public ModelAndView findAll() {
		return new ModelAndView("findAll", "employees", employeeService.findbyAll());
	}
}
