package com.yourhelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.yourhelp.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	
}
