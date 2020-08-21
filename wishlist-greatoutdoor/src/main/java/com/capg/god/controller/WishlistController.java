/******************************************
 - File Name      : WishlistController.java
 - Author           : Capgemini
 - Creation Date    : 11-08-2020
 - Description      : This Controller class act as an end point to manage the entire WishlistService
  ******************************************/
package com.capg.god.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.god.exception.WishlistException;
import com.capg.god.entity.Login;
import com.capg.god.entity.Product;
import com.capg.god.entity.Wishlist;
import com.capg.god.service.WishlistService;

@RestController
@CrossOrigin("*")
public class WishlistController{
	@Autowired
	WishlistService wishlistService;
	Logger log =LoggerFactory.getLogger(WishlistController.class);
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable("id")int id) 
	{
		Product product=wishlistService.findProductrById(id);
		return new ResponseEntity<>(product,HttpStatus.OK);
		
	}
	/******************************************
    - Method Name      : viewproduct
    - Input Parameters : Product 
    - Return type      : boolean
    - End Point Url    : /product
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : getting the product information from the database.
     ******************************************/	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> findAllProducts() 
	{
		List<Product> list = wishlistService.findAllProducts();
		ResponseEntity<List<Product>>  rt = new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		return rt;
	}
	
	/******************************************
    - Method Name      : addproduct
    - Input Parameters : Product 
    - Return type      : boolean
    - End Point Url    : /product
    -Request Method Type: PostMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : adding the product information to the database.
     ******************************************/	
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		Product t=wishlistService.createProduct(product);
		ResponseEntity<Product> tr=new ResponseEntity<Product>(t,HttpStatus.OK);
		return tr;
		

     }
	/******************************************
    - Method Name      : viewWishlist
    - Input Parameters : Wishlist
    - Return type      : boolean
    - End Point Url    : /wishlist
    -Request Method Type: GettMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : getting the wishlist information from the database.
     ******************************************/
		
	@GetMapping("/wishlist")
	public ResponseEntity<List<Wishlist>> findAllWishlists() 
	{
		List<Wishlist> list = wishlistService.findAllWishlists();
		ResponseEntity<List<Wishlist>>  rt = new ResponseEntity<List<Wishlist>>(list,HttpStatus.OK);
		return rt;
	}
	
	/******************************************
    - Method Name      : addWishlist
    - Input Parameters : Wishlist
    - Return type      : boolean
    - End Point Url    : /wishlist
    -Request Method Type: PostMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : adding wishlist information entered by user   into  the database.
     ******************************************/
	@PostMapping("/wishlist")
	public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist)
	{
		Wishlist t=wishlistService.createWishlist(wishlist);
		
		ResponseEntity<Wishlist> wl=new ResponseEntity<Wishlist>(t,HttpStatus.OK);
		
		return wl;
	}
	@GetMapping("/admin/login/{user}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username, @PathVariable("pass") String password) throws WishlistException
	{
	  
		 Login log = wishlistService.findUser(username,password);
		 if(log==null) {
			 throw new WishlistException("Login not successful");
		 }
		 return new ResponseEntity<>(log,HttpStatus.OK);
		
		
	}
	}
		

    
	
	
 
	



