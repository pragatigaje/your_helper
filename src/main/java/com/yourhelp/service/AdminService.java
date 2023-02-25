package com.yourhelp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yourhelp.entity.Admin;


@Service
public interface AdminService {

	public Admin createAdmin(Admin admin);
	public List<Admin> getAdmins();
	public Admin getAdminById(int id);
	public void deleteAdmin(int id);
	public Admin modify(Admin admin,int id);
	
	
}
