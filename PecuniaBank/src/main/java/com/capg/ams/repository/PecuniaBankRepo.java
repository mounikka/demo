package com.capg.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ams.model.BankAccountDetails;


public interface PecuniaBankRepo extends JpaRepository<BankAccountDetails, Long> {

}
