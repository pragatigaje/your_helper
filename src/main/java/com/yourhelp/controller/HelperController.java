package com.yourhelp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourhelp.entity.Helper;
import com.yourhelp.entity.User;
import com.yourhelp.repository.HelperRepository;
import com.yourhelp.service.HelperService;


@Controller
@RequestMapping("/helper")
public class HelperController {
	@Autowired
	HelperRepository repo;
	@Autowired
	HelperService service;
	
	@PostMapping("/save")
	public Helper saveHelper(@RequestBody Helper helper) {
		return service.createHelper(helper);
	}

	@GetMapping("/helperslist")
	public String getAllHelper(Model model) {
		model.addAttribute("helpers", service.getHelpers());
		return "helperslist";
	}
	
	@GetMapping("/gethelper/{id}")
	public Helper getHelper(@PathVariable int id)
	{
		return service.getHelperById(id);
	}
	
	@GetMapping("/helperslist/deletehelper/{id}")
	public String deleteHelper(@PathVariable int id){
		service.deleteHelper(id);
		return "redirect:/helper/helperslist";
	}
	
	@GetMapping("/helperslist/edit/{id}")
	public String editHelper(@PathVariable int id,Model model) {
		model.addAttribute("helper", service.getHelperById(id));
		return "helper_update";
	}
	
	@PostMapping("/updatehelper/{id}")
	public String updateHelper(@PathVariable int id,
			@ModelAttribute("helper") Helper helper, Model model ){
		service.modify(helper, id);
		return "redirect:/helper/helperslist";
	}
	
	@GetMapping("/carpenter")
	public String showCarpenter(Model model){
		model.addAttribute("carpenters", service.findCarpenter());
		return "carpenter";
	}
	@GetMapping("/labour")
	public String showLabour(Model model){
		model.addAttribute("labours", service.findLabour());
		return "labour";
	}
	@GetMapping("/electrician")
	public String showElectrician(Model model){
		model.addAttribute("electricians", service.findElectrician());
		return "electrician";
	}
	@GetMapping("/plumber")
	public String showPlumber(Model model){
		model.addAttribute("plumbers", service.findPlumber());
		return "plumber";
	}
	@GetMapping("/loginhelper")
	public String showloginUserForm(Model model) {
		Helper helper = new Helper();
		model.addAttribute("helper", helper);
		return "loginhelper";
	}
	@PostMapping("/process_login")
	public String processlogin(Helper helper,Model model) {
		String pass = helper.getPassword();
		String uname = helper.getUsername();
	
		List<Helper> lst = repo.findAll();
		for (Helper user2 : lst) {

			if (user2.getPassword().equals(pass) && user2.getUsername().equals(uname)) {
				Helper h1  = repo.findById(user2.getId()).orElse(null);
				model.addAttribute("helper", h1);
				return "helper_home";
			} else {
				continue;

			}

		}



		return "loginhelper";
	}
	
	
	@GetMapping("/newhelper")
	public String showNewUserForm(Model model) {
		Helper helper = new Helper();
		model.addAttribute("helper", helper);
		return "new_helper";
	}
	@PostMapping("/processregister")
	public String processRegistration(Helper user) {
	
		String uname = user.getUsername();

		List<Helper> lst = repo.findAll();
		for (Helper user2 : lst) {

			if (user2.getUsername().equals(uname)) {
				return "no_sucess";
			} else {
				continue;

			}

		}

		repo.save(user);

		return "register_sucess";
	}
	@GetMapping("/helperslist/edithelper/{id}")
	public String editHelpers(@PathVariable int id,Model model) {
		model.addAttribute("helper", service.getHelperById(id));
		return "helper_update_profile";
	}
	
	@PostMapping("/updatehelperprofile/{id}")
	public String updateHelperprofile(@PathVariable int id,
			@ModelAttribute("helper") Helper helper, Model model ){
		service.modify(helper, id);
		return "helper_home";
	}
	
}
