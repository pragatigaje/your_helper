package com.yourhelp.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PagesController {

	
	
	
	
	@GetMapping("/home")
	public String homeView(){
		return "front";
	}

	@GetMapping("/about")
	public String aboutView(){
		return "about";
	}
	
	@GetMapping("/contactus")
	public String aboutContact(){
		return "contactus";
	}
	
	@GetMapping("/login")
	public String login(){
		return "logincard";
	}
	@GetMapping("/logout")
	public String logout(){
		return "front";
	}
	@GetMapping("/user_home")
	public String user_home(){
		return "user_home";
	}


	
	
}
