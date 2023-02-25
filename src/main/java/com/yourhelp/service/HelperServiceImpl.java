package com.yourhelp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourhelp.entity.Helper;
import com.yourhelp.repository.HelperRepository;

@Service
public class HelperServiceImpl implements HelperService {
	@Autowired
	HelperRepository repo;
	
	
	@Override
	public Helper createHelper(Helper helper) {
		
		return repo.save(helper);
	}

	@Override
	public List<Helper> getHelpers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Helper getHelperById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void deleteHelper(int id) {
		repo.deleteById(id);
	}
	
	@Override
	public Helper modify(Helper helper, int id) {
		
		Helper old = repo.findById(id).orElse(null);
		old.setId(helper.getId());
		old.setName(helper.getName());
		old.setUsername(helper.getUsername());
		old.setPassword(helper.getPassword());
		old.setType(helper.getType());
		repo.save(old);
		return helper;
	}

	@Override
	public List<Helper> findPlumber() {
		List<Helper> lst = repo.findAll();
		List<Helper> hlst = new ArrayList<Helper>();
		for (Helper helper : lst) {
			if(helper.getType().equals("plumber")) {
				hlst.add(helper);
			}else {
				continue;
			}
		}
		return hlst;
	}

	@Override
	public List<Helper> findElectrician() {
		List<Helper> lst = repo.findAll();
		List<Helper> hlst = new ArrayList<Helper>();
		for (Helper helper : lst) {
			if(helper.getType().equals("electrician")) {
				hlst.add(helper);
			}else {
				continue;
			}
		}
		return hlst;
	}

	@Override
	public List<Helper> findLabour() {
		List<Helper> lst = repo.findAll();
		List<Helper> hlst = new ArrayList<Helper>();
		for (Helper helper : lst) {
			if(helper.getType().equals("labour")) {
				hlst.add(helper);
			}else {
				continue;
			}
		}
		return hlst;
	}

	@Override
	public List<Helper> findCarpenter() {
		List<Helper> lst = repo.findAll();
		List<Helper> hlst = new ArrayList<Helper>();
		for (Helper helper : lst) {
			if(helper.getType().equals("carpenter")) {
				hlst.add(helper);
			}else {
				continue;
			}
		}
		return hlst;
	}
	
	
}
