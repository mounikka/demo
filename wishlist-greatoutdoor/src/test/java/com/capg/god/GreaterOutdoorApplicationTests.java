package com.capg.god;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.god.entity.Product;
import com.capg.god.entity.Wishlist;
import com.cap.god.exception.WishlistException;
import com.capg.god.dao.ProductDao;
import com.capg.god.dao.Userdao;
import com.capg.god.dao.WishlistDao;
import com.capg.god.service.WishlistService;

@SpringBootTest
class GreaterOutdoorApplicationTests {

	@Autowired
	   private WishlistService wishlistservice;
	   
	   @MockBean
	   private WishlistDao wishlistdao;
	    
	   @MockBean
	   private ProductDao productdao;
	   
	   @MockBean
	   private Userdao userdao;
	   
		@Test
		void contextLoads() {
		}
	 
		@Test
		public void getProductsTest() throws WishlistException{
			when(productdao.findAll()).thenReturn(Stream.of(new Product()).collect(Collectors.toList()));
			assertEquals(1,wishlistservice.findAllProducts().size());
			
		}
		@Test
		public void getWishlistsTest() throws WishlistException{
		when(wishlistdao.findAll()).thenReturn(Stream.of(new Wishlist()).collect(Collectors.toList()));
		assertEquals(1,wishlistservice.findAllWishlists().size());
			
		}

}
