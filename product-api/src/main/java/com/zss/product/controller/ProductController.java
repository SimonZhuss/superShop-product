package com.zss.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zss.product.entity.AjaxData;
import com.zss.product.entity.BaseResEntity;
import com.zss.product.entity.ResponseEntity;
import com.zss.product.req.ProductReq;
import com.zss.product.service.ProductService;
import com.zss.product.service.rpc.entity.UserInfo;
import com.zss.product.service.rpc.entity.UserReq;

/**
 * 产品控制器
 * @author zhushanshan
 * 2017年11月1日 下午6:19:33
 */
@Api(value = "产品制器")
@RestController
@RequestMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;
    
	@ApiOperation(value = "查询产品", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = ResponseEntity.class)
    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
	@ResponseBody
    public BaseResEntity queryById(@RequestBody ProductReq productReq){
        try{
        	BaseResEntity result =productService.queryByCondition(productReq);
        	return result;
        }catch(Exception e){
            log.error("发生异常:",e);
            return BaseResEntity.failure();
        }
    }
	
	@ApiOperation(value = "根据用户名查询用户", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = ResponseEntity.class)
    @RequestMapping(value = "/queryUserByName", method = RequestMethod.POST)
	@ResponseBody
    public AjaxData<List<UserInfo>> queryUserByName(@RequestBody UserReq userReq){
		AjaxData<List<UserInfo>> result =productService.queryUserByName(userReq);
    	return result;
    }
}
