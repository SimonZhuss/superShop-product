package com.zss.product.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.zss.product.entity.AjaxData;
import com.zss.product.entity.BaseResEntity;
import com.zss.product.req.ProductReq;
import com.zss.product.service.rpc.entity.UserInfo;
import com.zss.product.service.rpc.entity.UserReq;

public interface ProductService {
	
	public BaseResEntity queryByCondition(ProductReq productReq);
	
	 AjaxData<List<UserInfo>> queryUserByName(@RequestBody UserReq req);
}
