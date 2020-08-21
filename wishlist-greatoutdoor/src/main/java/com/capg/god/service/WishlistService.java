/******************************************
 - File Name      : WishlistService.java
 - Author           : Capgemini
 - Creation Date    : 11-08-2020
 - Description      : This Wishhlist Interface used to implement service.
  ******************************************/
package com.capg.god.service;

import java.util.List;

import com.cap.god.exception.WishlistException;
import com.capg.god.entity.Login;
import com.capg.god.entity.Product;
import com.capg.god.entity.Wishlist;


public interface WishlistService  {
	public Product findProductrById(int productId) throws WishlistException;
	public List<Product>  findAllProducts() throws WishlistException;
	public Product createProduct(Product product);
	public List<Wishlist>  findAllWishlists() throws WishlistException;
	public Wishlist createWishlist(Wishlist wishlist);
	public Login findUser(String username , String password) throws WishlistException;
	
	

}
