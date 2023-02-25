package com.yourhelp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yourhelp.entity.Helper;


@Service
public interface HelperService {

	public Helper createHelper(Helper helper);
	public List<Helper> getHelpers();
	public Helper getHelperById(int id);
	public void deleteHelper(int id);
	public Helper modify(Helper helper,int id);
	public List<Helper> findPlumber();
	public List<Helper> findElectrician();
	public List<Helper> findLabour();
	public List<Helper> findCarpenter();
	
	
}
