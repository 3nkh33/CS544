package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.User;
import edu.mum.service.UserService;

@Component
@RequestMapping({"/users"})
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping({"","/all"})
	public String listUsers(Model model) {
		model.addAttribute("users",userService.findAll());
		return "users";
	}
	
	@RequestMapping("/{id}")
	public String getUserById(Model model, @PathVariable("id") Long id) {
		User u = userService.findOne(id);
		model.addAttribute("user",u);
		return "user";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getAddNewUserForm(@ModelAttribute("newUser") User newUser) {
		return "addUser";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String processAddNewUserForm(@ModelAttribute("newUser") @Valid User u, BindingResult result ) {
		if(result.hasErrors()) {
			return "addUser";
		}
		
		try {
			userService.save(u);
		}catch(Exception e) {
			System.out.println("Transaction failed");
		}
		return "redirect:/users";
	}
	
}
