/******************************************
 - File Name        : LoginDao.java
 - Author           : Capgemini
 - Creation Date    : 11-08-2020
 - Description      : This  class is used as dao.
  ******************************************/
package com.capg.god.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.god.entity.Login;

public interface LoginDao extends JpaRepository<Login, String> {
	
	@Query(" FROM Login where username=:username1 and password=:pass1")
	public Login findUser(@Param("username1") String username,@Param("pass1") String password);
	
	}
		



