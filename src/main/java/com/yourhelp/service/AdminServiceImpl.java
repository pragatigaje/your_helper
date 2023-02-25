package com.yourhelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourhelp.entity.Admin;

import com.yourhelp.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository repo;
	
	
	@Override
	public Admin createAdmin(Admin admin) {
		
		return repo.save(admin);
	}


	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}


	@Override
	public void deleteAdmin(int id) {
		repo.deleteById(id);
		
	}


	@Override
	public Admin modify(Admin admin, int id) {
		
		Admin old = repo.findById(id).orElse(null);
		old.setId(admin.getId());
		old.setName(admin.getName());
		old.setUsername(admin.getUsername());
		old.setPassword(admin.getPassword());
		repo.save(old);
		
		return admin;
	}

		
	
	
	
	
}
