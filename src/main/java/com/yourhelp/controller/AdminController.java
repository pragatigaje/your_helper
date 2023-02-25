package com.yourhelp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourhelp.entity.Admin;
import com.yourhelp.entity.Helper;
import com.yourhelp.repository.AdminRepository;
import com.yourhelp.repository.HelperRepository;
import com.yourhelp.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminRepository repo;
	@Autowired
	AdminService service;
	
	@PostMapping("/save")
	public Admin saveAdmin(@RequestBody Admin admin) {
		
		return service.createAdmin(admin);
		
		
	}
	@GetMapping("/adminlist")
	public List<Admin> getAllAdmin() {
		return service.getAdmins();
	}
	
	@GetMapping("/getadmin/{id}")
	public Admin getAdmin(@PathVariable int id)
	{
		return service.getAdminById(id);
	}
	@DeleteMapping("/deleteadmin/{id}")
	public void deleteAdmin(@PathVariable int id){
		service.deleteAdmin(id);
		
	}
	
	@PutMapping("/updateadmin/{id}")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable int id){
		return service.modify(admin, id);
	}
	
	@PostMapping("/process_login")
	public String processlogin(Admin helper) {
		String pass = helper.getPassword();
		String uname = helper.getUsername();

		List<Admin> lst = repo.findAll();
		for (Admin user2 : lst) {

			if (user2.getPassword().equals(pass) && user2.getUsername().equals(uname)) {
				return "admin";
			} else {
				continue;

			}

		}



		return "loginadmin";
	}
	@GetMapping("/loginadmin")
	public String showloginUserForm(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "loginadmin";
	}
	
	
}
