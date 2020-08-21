/******************************************
 - File Name        : UserDao.java
 - Author           : Capgemini
 - Creation Date    : 11-08-2020
 - Description      : This  class is used as dao.
  ******************************************/
package com.capg.god.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.god.entity.User;

@Repository
public interface Userdao  extends JpaRepository<User, Integer> {

}
