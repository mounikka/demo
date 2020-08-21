/******************************************
 - File Name        : Wishlist.java
 - Author           : Capgemini
 - Creation Date    : 11-08-2020
 - Description      : This  class is used as entity.
  ******************************************/
package com.capg.god.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="wishlist_table")
public class Wishlist {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @SequenceGenerator(name="mygen",sequenceName="wishlist_seq",allocationSize=1)
	    @Column(name = "wid")
	    private Long wid;
	    
	 
	    @ManyToOne
	    @JoinColumn(name = "userid")
		private User user;
		 
	    
		@ManyToOne
		@JoinColumn(name="productid")
		private Product  product;

		
		public Long getWid() {
			return wid;
		}

		public void setWid(Long wid) {
			this.wid = wid;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		}

    

	

