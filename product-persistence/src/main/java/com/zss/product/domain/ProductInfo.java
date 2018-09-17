package com.zss.product.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_product")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo implements Serializable{
	private static final long serialVersionUID = 4837516662494149448L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	private Long productId;
    
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_amount")
	private String productAmount;
	
	@Column(name = "create_user")
	private Long createUser;
	
	@Column(name = "product_status")
	private Integer productStatus;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "modify_time")
	private Date modifyTime;
}