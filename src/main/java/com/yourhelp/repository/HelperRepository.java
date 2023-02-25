package com.yourhelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yourhelp.entity.Helper;


public interface HelperRepository extends JpaRepository<Helper, Integer>{
	
	@Query(value = "SELECT * FROM HELPER WHERE type = carpenter", nativeQuery = true)
			List<Helper> findCarpenter();
	
	@Query(value = "SELECT * FROM HELPER u WHERE u.type = labour", nativeQuery = true)
		List<Helper> findLabour();
	
	@Query(value = "SELECT * FROM HELPER u WHERE u.type = electrician", nativeQuery = true)
		List<Helper> findElectrician();
	
	@Query(value = "SELECT * FROM HELPER u WHERE u.type = plumber", nativeQuery = true)
		List<Helper> findPlumber();	
	
}
