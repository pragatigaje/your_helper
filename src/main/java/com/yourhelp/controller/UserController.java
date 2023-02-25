package com.yourhelp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourhelp.entity.User;
import com.yourhelp.repository.UserRepository;
import com.yourhelp.service.UserService;


@Controller
public class UserController {
	// display list of users
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository repository;

	@GetMapping("/HomePage")
	public String viewMainPage() {
		return "HomePage";
	}

	@GetMapping("/register")
	public String showSignUpForm(Model model) {

		model.addAttribute("user", new User());

		return "signup_form";

	}

	@PostMapping("/process_register")
	public String processRegistration(User user) {
		String eMail = user.geteMail();
		String uname = user.getUname();

		List<User> lst = repository.findAll();
		for (User user2 : lst) {

			if (user2.geteMail().equals(eMail) || user2.getUname().equals(uname)) {
				return "no_sucess";
			} else {
				continue;

			}

		}

		repository.save(user);

		return "register_sucess";
	}

	@GetMapping("/")
	public String viewHomePage(Model model) {

		return findPaginated(1, model);

//		model.addAttribute("listUsers", userService.getAllUsers());
//		return "index";

	}

	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		// save user to the database
		userService.saveUser(user);
		return "redirect:/";

	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
		// Get y=user from the serivce
		User user = userService.getUserById(id);
		// set user as a model att to pre populate the form
		model.addAttribute("user", user);
		return "update_user";

	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value = "id") int id) {
		// delete method from service
		this.userService.deleteUserById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 5;

		Page<User> page = userService.findPaginated(pageNo, pageSize);
		List<User> listUSers = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listUSers", listUSers);
		return "index";

	}
	@PostMapping("/process_login")
	public String processlogin(User user) {
		String pass = user.getPassWord();
		String uname = user.getUname();

		List<User> lst = repository.findAll();
		for (User user2 : lst) {

			if (user2.getPassWord().equals(pass) && user2.getUname().equals(uname)) {
				return "user_home";
			} else {
				continue;

			}

		}



		return "loginuser";
	}
	
	@GetMapping("/loginuser")
	public String showloginUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "loginuser";
	}

}
