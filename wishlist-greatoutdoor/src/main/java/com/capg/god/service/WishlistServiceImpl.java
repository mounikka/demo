/******************************************
 - File Name      : WishlistServiceImpl.java
 - Author           : Capgemini
 - Creation Date    : 11-08-2020
 - Description      : This WishhlistserviceImpl used for the logic.
  ******************************************/
package com.capg.god.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.god.exception.WishlistException;
import com.capg.god.dao.LoginDao;
import com.capg.god.dao.ProductDao;
import com.capg.god.dao.Userdao;
import com.capg.god.dao.WishlistDao;
import com.capg.god.entity.Login;
import com.capg.god.entity.Product;
import com.capg.god.entity.Wishlist;


@Service
public class WishlistServiceImpl implements WishlistService   {
	

	
	@Autowired
	WishlistDao wishlistdao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	Userdao userdao;
	
	@Autowired
	LoginDao loginDao;


	     @Override
	     public Product findProductrById(int productId)  {
	        Product product=null;
	        boolean flag=productDao.existsById(productId);
	        if(flag)
		{
		
		    product=productDao.findById(productId).get();

		}
		else
		{
			throw new WishlistException("id does not found");
		}
		
		    return product;
	    }

	     @Override
	     public List<Product> findAllProducts() {
		    List<Product> list=productDao.findAll();
		    return list;
	    }

	     @Override
	     public Product createProduct(Product product) {
            Product tr=productDao.saveAndFlush(product);
		    return tr;
	    
	    }
	     @Override
	     public List<Wishlist> findAllWishlists() throws WishlistException {
		    List<Wishlist> list=wishlistdao.findAll();
		    return list;
	     }

		@Override
		public Wishlist createWishlist(Wishlist wishlist) {
			Wishlist wl=wishlistdao.saveAndFlush(wishlist);
		    return wl;
			
		}

		@Override
		public Login findUser(String username, String password)  {
			
			return loginDao.findUser(username,password);
			
		}

		
		}

	
		

	
			


   
