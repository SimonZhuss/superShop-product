package com.zss.product.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zss.product.domain.ProductInfo;
import com.zss.product.entity.AjaxData;
import com.zss.product.entity.BaseResEntity;
import com.zss.product.entity.ResponseEntity;
import com.zss.product.repository.ProductRepository;
import com.zss.product.req.ProductReq;
import com.zss.product.service.ProductService;
import com.zss.product.service.rpc.UserServiceClient;
import com.zss.product.service.rpc.entity.UserInfo;
import com.zss.product.service.rpc.entity.UserReq;
import com.zss.product.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserServiceClient userServiceClient;
	
	@Autowired
    RestTemplate restTemplate;

	@Override
	public BaseResEntity queryByCondition(ProductReq productReq) {
		AjaxData<List<UserInfo>> userAjax = userServiceClient.queryByCondition(new UserReq("aa"));
		log.info(">>>>>>调用用户模块||result:{}",JsonUtil.printStrFromObj(userAjax));
		ProductInfo productInfo = productRepository.findOne(productReq.getProductId());
		return ResponseEntity.success(productInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	@HystrixCommand(fallbackMethod = "hiError")
	public AjaxData<List<UserInfo>> queryUserByName(UserReq req) {
		return restTemplate.postForObject("http://user-server/user/queryByCondition", new UserReq("aa"), AjaxData.class);
	} 

	public AjaxData<List<UserInfo>> hiError(UserReq req) {
        return AjaxData.fusing("user-server");
    }
}
