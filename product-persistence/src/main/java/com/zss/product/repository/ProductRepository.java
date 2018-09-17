package com.zss.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zss.product.domain.ProductInfo;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Long>{
	
}