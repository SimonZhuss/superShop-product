package com.zss.product.service;

import com.zss.product.entity.BaseResEntity;
import com.zss.product.req.ProductReq;

public interface ProductService {
	
	public BaseResEntity queryByCondition(ProductReq productReq);
}
