/******************************************
 - File Name        : User.java
 - Author           : Capgemini
 - Creation Date    : 11-08-2020
 - Description      : This  class is used as entity.
  ******************************************/
package com.capg.god.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "USER_Table")
public class User  {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @SequenceGenerator(name="mygen",sequenceName="user_seq",allocationSize=1)
	    @Column(name = "userid")
	    private int  userid;

	    private String username;
	    
	    private int password;

	   
	    @OneToMany(mappedBy="user")
	    @JsonIgnore
  		List<Wishlist>  wishlist = new ArrayList<>();



		public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public int getPassword() {
			return password;
		}

		public void setPassword(int password) {
			this.password = password;
		}

		public List<Wishlist> getWishlist() {
			return wishlist;
		}

		public void setWishlist(List<Wishlist> wishlist) {
			this.wishlist = wishlist;
		}


	   

	    
}
