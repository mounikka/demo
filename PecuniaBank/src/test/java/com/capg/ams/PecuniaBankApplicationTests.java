package com.capg.ams;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.ams.model.BankAccountDetails;
import com.capg.ams.model.CustomerAddress;
import com.capg.ams.repository.PecuniaBankRepo;
import com.capg.ams.service.IPecuniaBankService;
import com.capg.ams.service.PecuniaBankService;



@RunWith(SpringRunner.class)
@SpringBootTest
class PecuniaBankApplicationTests {
	@Mock
	private BankAccountDetails account;
	
	@Mock
	private PecuniaBankRepo repo;
	
	@InjectMocks
	private PecuniaBankService ser;
	
	
	  @Before 
	  public void setup() 
	  { 
		  MockitoAnnotations.initMocks(this);
	  }
	 
	@Test
	public void addAccountTest() throws Exception {
		BankAccountDetails accountt=mock(BankAccountDetails.class);
		ser.addAccount(accountt);
		verify(repo).save(accountt);	
		}
	
	
	
	}
	
	
	

	

